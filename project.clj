(defproject compojure "0.1.0-SNAPSHOT"
  :uberjar-name "compojure.jar"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.3.0"]
                 [clj-time "0.12.2"]
                 [compojure "1.5.1" :exclusions [ring/ring-core]]
                 [de.ubercode.clostache/clostache "1.3.1"]
                 [environ "1.1.0"]
                 [markdown-clj "0.9.99"]
                 [net.sf.uadetector/uadetector-resources "2013.02"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/java.jdbc "0.5.8"]
                 [org.postgresql/postgresql "42.0.0"]
                 [ring "1.6.3"]
                 [ring/ring-anti-forgery "1.1.0"]
                 [ring/ring-defaults "0.3.1" ]
                 [ring/ring-json "0.4.0"]
                 [selmer "1.10.7" :exclusions [joda-time
                                               com.fasterxml.jackson.dataformat/jackson-dataformat-cbor
                                               com.fasterxml.jackson.core/jackson-core]]
                 [venantius/ultra "0.5.1" :exclusions [instaparse]]]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]
                   :plugins [[lein-environ "1.1.0"]
                             [lein-cljfmt "0.5.6"]
                             [lein-ring "0.12.0"]]}
             :uberjar {:aot :all}}
  :ring {:handler       server.routes/app  ; lein ring server uses this as
         :port          8080               ; the entrypoint
         :ssl-port      8443
         :send-server-version? false
         :keystore      "ssl-certs/java_key_store"
         :key-password  ~(System/getenv "quandl_api_key")
         :ssl?          true}
  :target-path "target/%s"
  :main ^:skip-aot server.routes
  :jvm-opts ["-Xms256m" "-Xmx256m" "-XX:MaxMetaspaceSize=128m"
             "-client" "-Duser.timezone=PST8PDT"
             "-Dclojure.compiler.direct-linking=true"
             "-XX:-OmitStackTraceInFastThrow"])
