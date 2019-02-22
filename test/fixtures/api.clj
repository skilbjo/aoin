(ns fixtures.api
  (:require [clj-time.coerce :as coerce]
            [clojure.data.json :as json]))

(def api-response-from-currency
  "{\"body\": [
   {\"dataset\":  \"CURRFX\",
   \"ticker\":   \"GBPUSD\",
   \"currency\": \"GBP\",
   \"date\":     \"2017-12-15T00:00:00Z\",
   \"rate\":     1.34329152107240,
   \"high\":     1.34498989582060,
   \"low\":      1.33081364631650},
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"EURUSD\",
   \"currency\": \"EUR\",
   \"date\":     \"2017-12-15T00:00:00Z\",
   \"rate\":     1.17749571800230,
   \"high\":     1.18140053749080,
   \"low\":      1.17616617679600}
   {\"dataset\":  \"CURRFX\",
   \"ticker\":   \"GBPUSD\",
   \"currency\": \"GBP\",
   \"date\":     \"2017-12-14T00:00:00Z\",
   \"rate\":     1.34096789360050,
   \"high\":     1.34556913375850,
   \"low\":      1.33951294422150},
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"EURUSD\",
   \"currency\": \"EUR\",
   \"date\":     \"2017-12-14T00:00:00Z\",
   \"rate\":     1.18358600139620,
   \"high\":     1.18598639965060,
   \"low\":      1.17716300487520}
   ]}")

(def result-latest
  (-> api-response-from-currency
      (json/read-str
       :key-fn keyword
       :value-fn (fn [k v]
                   (condp = k
                     :date (coerce/to-sql-date v)
                     :rate (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     :high (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     :low  (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     v)))))

(def api-response-from-portfolio
  "{\"body\": [
   {\"dataset\":  \"CURRFX\",
   \"ticker\":   \"GBPUSD\",
   \"currency\": \"GBP\",
   \"date\":     \"2017-12-15T00:00:00Z\",
   \"rate\":     1.34329152107240,
   \"high\":     1.34498989582060,
   \"low\":      1.33081364631650},
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"EURUSD\",
   \"currency\": \"EUR\",
   \"date\":     \"2017-12-15T00:00:00Z\",
   \"rate\":     1.17749571800230,
   \"high\":     1.18140053749080,
   \"low\":      1.17616617679600}
   {\"dataset\":  \"CURRFX\",
   \"ticker\":   \"GBPUSD\",
   \"currency\": \"GBP\",
   \"date\":     \"2017-12-14T00:00:00Z\",
   \"rate\":     1.34096789360050,
   \"high\":     1.34556913375850,
   \"low\":      1.33951294422150},
   {\"dataset\": \"CURRFX\",
   \"ticker\":   \"EURUSD\",
   \"currency\": \"EUR\",
   \"date\":     \"2017-12-14T00:00:00Z\",
   \"rate\":     1.18358600139620,
   \"high\":     1.18598639965060,
   \"low\":      1.17716300487520}
   ]}")

(def result-latest
  (-> api-response-from-portfolio
      (json/read-str
       :key-fn keyword
       :value-fn (fn [k v]
                   (condp = k
                     :date (coerce/to-sql-date v)
                     :rate (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     :high (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     :low  (-> v java.math.BigDecimal. (.setScale 14 BigDecimal/ROUND_HALF_UP))
                     v)))))
