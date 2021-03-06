(ns jobs.api
  (:require [clj-time.coerce :as coerce]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [environ.core :refer [env]]
            [server.spec :as s]
            [server.sql :as sql]
            [server.util :as util]))

(def ^:private login-error-counter
  (atom 0))

(defn ^:private authorized? [{:keys [user password]}]
  (let [dir     (if (env :jdbc-athena-uri)
                  "athena"
                  "dw")
        f       (if (env :jdbc-athena-uri)
                  sql/query-athena
                  sql/query'')
        result  (-> (->> "/login.sql"
                         (str dir)
                         io/resource
                         slurp)
                    (f {:user     user
                        :password password})
                    first)]
    {:user     (:_user result)
     :password (:password result)}))

(defn ^:private unauthorized [{:keys [user password]}]
  (swap! login-error-counter inc)
  (let [msg (str "Unauthorized Login Report\n\n"
                 "Attempts: %s \n"
                 "Attempted access with \n"
                 "user: %s \n"
                 "hashed-password: %s")
        warn-msg (format msg
                         @login-error-counter
                         user
                         password)]

    (log/warn warn-msg)

    ;; email on 10 unauth'd attempts & every 5 thereafter
    (when (and (->> @login-error-counter
                    (<= 10))
               (-> @login-error-counter
                   (mod 5)
                   (= 0)))
      (util/email "Unauthorized Login Report" warn-msg))

    {:status 401
     :body "Wrong username, password, or both, bucko"}))

(defn v1.login [{:keys [user password]}]
  (let [result (authorized? {:user     user
                             :password password})]
    (if (and (= (:user     result) user)
             (= (:password result) password)
             (not (empty? result)))
      {:body {:user      user       ;; TODO for token: password is
              :token     password}} ;; hashed, but is there a better way?
      (unauthorized {:user     user
                     :password password}))))

(defn ^:private report [{:keys [user password] :as m} report]
  (let [data  (fn [_]
                (let [dir (if (env :jdbc-athena-uri)
                            "athena"
                            "dw")
                      f   (if (env :jdbc-athena-uri)
                            sql/query-athena
                            sql/query'')]
                  (->> (-> (str dir
                                (str "/reports/" report)
                                (when (env :jdbc-athena-uri)
                                  "_athena")
                                ".sql")
                           io/resource
                           slurp
                           (f {:user user}))
                       (map #(update % :date coerce/to-sql-date)))))
        data' (memoize data)
        result (authorized? {:user     user
                             :password password})]
    (if (and (= (:user     result) user)
             (= (:password result) password)
             (not (empty? result)))
      {:body (data' util/now')}
      (unauthorized {:user     user
                     :password password}))))

(defn v1.portfolio [m]
  (report m "portfolio"))

(defn v1.asset-type [m]
  (report m "asset_type"))

(defn v1.capitalization [m]
  (report m "capitalization"))

(defn v1.investment-style [m]
  (report m "investment_style"))

(defn v1.location [m]
  (report m "location"))

(defn v1.latest [dataset]
  (if (false? (s/allowed-endpoint? s/datasets dataset))
    {:status 400
     :body (util/multi-line-string (format
                                    "Error: '/api/%s' is not a valid endpoint."
                                    dataset)
                                   "Try /api/equities or /api/currency.")}
    (let [data  (fn [_]
                  (let [dir      (if (env :jdbc-athena-uri)
                                   "athena"
                                   "dw")
                        f        (if (env :jdbc-athena-uri)
                                   sql/query-athena
                                   sql/query')
                        sql-file "latest"]
                    (->> (-> (str dir "/prices/" sql-file ".sql")
                             io/resource
                             slurp
                             (f {:table (str dataset "_fact")}))
                         (map #(update % :date coerce/to-sql-date)))))
          data' (memoize data)]
      {:body (data' util/now')}))) ; cache the request by date

(defn v1.quote [dataset ticker date]
  (log/debug "params are: " dataset ticker date)
  (if (not (s/allowed-endpoint? s/datasets dataset))
    {:status 400
     :body (util/multi-line-string
            "Error: problem with dataset, ticker, or date."
            "Try '/api/v1/prices/equities?ticker=FB&date=2017-09-05'"
            "Remember 'Authorization: Token [token]' header"
            "For authorization parameter, make sure to include 'Token ' literal")}
    (let [data  (fn [_]
                  (let [dir      (if (env :jdbc-athena-uri)
                                   "athena"
                                   "dw")
                        f        (if (env :jdbc-athena-uri)
                                   sql/query-athena
                                   sql/query')
                        sql-file (if (some (partial = dataset) ["equities" "currency"])
                                   dataset
                                   "quote")]
                    (->> (-> (str dir "/prices/" sql-file ".sql")
                             io/resource
                             slurp
                             (f {:table  (str dataset "_fact")
                                 :ticker ticker
                                 :date   date}))
                         (map #(update % :date coerce/to-sql-date)))))
          data' (memoize data)]
      {:body (data' util/now')})))
