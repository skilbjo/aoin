(defproject aeon "0.1.0"
  :uberjar-name "app.jar"
  :dependencies [;; clj
                 [org.clojure/clojure "1.9.0"]
                 [bk/ring-gzip "0.3.0"]
                 [buddy/buddy-auth "2.2.0"]
                 [buddy/buddy-core "1.6.0"]
                 [clj-http "3.10.0"]
                 [clj-time "0.15.2"]
                 [com.syncron.amazonaws/simba-athena-jdbc-driver "2.0.2"]
                 [com.draines/postal "2.0.3"]
                 [compojure "1.6.1" :exclusions [ring/ring-core]]
                 [metosin/compojure-api "2.0.0-alpha20"
                  :exclusions [cheshire
                               com.fasterxml.jackson.dataformat/jackson-dataformat-cbor
                               com.fasterxml.jackson.dataformat/jackson-dataformat-smile
                               com.google.code.findbugs/jsr305]]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 [environ "1.1.0"]
                 [hiccup "1.0.5"]
                 [jarohen/chime "0.2.2"]
                 [markdown-clj "1.10.0"]
                 [metosin/spec-tools "0.10.0"
                  :exclusions [com.fasterxml.jackson.core/jackson-core]]
                 [net.sf.uadetector/uadetector-resources "2014.10"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/java.jdbc "0.7.10"]
                 [org.clojure/tools.logging "0.5.0"]
                 [org.postgresql/postgresql "42.2.8"]
                 [org.slf4j/slf4j-log4j12 "1.7.28"
                  :exclusions [org.clojure/tools.reader
                               org.slf4j/slf4j-api]]
                 [ring "1.7.1"]
                 [ring/ring-anti-forgery "1.3.0"]
                 [ring/ring-defaults "0.3.2" ]
                 [ring/ring-json "0.5.0"]
                 [ring-cors "0.1.13"]

                 ;; cljs
                 [org.clojure/clojurescript "1.10.520"
                  :exclusions [com.google.code.findbugs/jsr305
                               com.fasterxml.jackson.core/jackson-core]]

                 [cljs-ajax "0.8.0" :exclusions [com.fasterxml.jackson.core/jackson-core
                                                 com.fasterxml.jackson.core/jackson-dataformat-cbor
                                                 cheshire]]
                 [cljs-log "0.2.3"]
                 [com.andrewmcveigh/cljs-time "0.5.2"]
                 [day8.re-frame/http-fx "0.1.6"]
                 [day8.re-frame/tracing-stubs "0.5.3"]
                 [re-frame "0.10.9"
                  :exclusions [com.google.code.findbugs/jsr305]]
                 [re-frame-datatable "0.6.0"]
                 [reagent "0.8.1"]
                 [secretary "1.2.3"]]
  :plugins [[lein-cloverage "1.0.11"]
            [lein-cljsbuild "1.1.7"]]
  :clean-targets ^{:protect false} ["resources/public/js"]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds {:app
                       {:source-paths ["src/app"]
                        :compiler
                        {:main        "app.core"
                         :asset-path  "js/app"
                         :output-dir  "resources/public/js/app"
                         :output-to   "resources/public/js/app.js"}}}}
  :profiles {:dev {:env {:log-level "1"} ;; cljs/log debug+
                   :dependencies [[binaryage/devtools "0.9.10"]
                                  [com.bhauman/cljs-test-display "0.1.1"]
                                  [day8.re-frame/re-frame-10x "0.4.3"
                                   :exclusions [com.google.code.findbugs/jsr305]]
                                  [day8.re-frame/tracing "0.5.3"]
                                  [javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.4.0"
                                   :exclusions [cheshire]]]
                   :plugins [[lein-cljfmt "0.5.7"]
                             [lein-environ "1.1.0"]
                             [lein-figwheel "0.5.19"]
                             [lein-ring "0.12.0"]]
                   :figwheel {:css-dirs ["resources/public/css"]
                              :ring-handler server.routes/app
                              :server-port 8081
                              :server-logfile false}
                   :cljsbuild {:builds {:app
                                        {:figwheel {:open-urls ["http://localhost:8081/cljs"]}
                                         :compiler
                                         {:optimizations   :none
                                          :preloads        [devtools.preload
                                                            day8.re-frame-10x.preload]
                                          :pretty-print    true
                                          :source-map      true
                                          :source-map-timestamp true
                                          :closure-defines  {"app.events.backend_uri" "http://localhost:8081"
                                                             goog.DEBUG true
                                                            "re_frame.trace.trace_enabled_QMARK_" true
                                                            "day8.re_frame.tracing.trace_enabled_QMARK_" true}
                                          :external-config {:devtools/config
                                                            {:features-to-install :all}}}}
                                        :test
                                        {:figwheel {:open-urls ["http://localhost:8081/test.html"]}
                                         :source-paths ["test/app"]
                                         :compiler
                                         {:optimizations   :none
                                          :main        "app.runner"
                                          :asset-path  "js/test"
                                          :output-dir  "resources/public/js/test"
                                          :output-to   "resources/public/js/test.js"
                                          :pretty-print    true
                                          :closure-defines
                                          {cljs-test-display.core/root-node-id "cljs-tests"
                                           cljs-test-display.core/printing true}}}}}}
             :uberjar {:aot :all
                       :cljsbuild {:builds {:app {:compiler {:closure-defines {"app.events.backend_uri" "https://skilbjo-api.duckdns.org"
                                                                               goog.DEBUG false}
                                                             :optimizations :advanced
                                                             :pretty-print  false}}}}
                       :env {:log-level "3"}}} ;; cljs/log warn+
  :ring {:handler       server.routes/app  ; lein ring server uses this as
         :port          8080               ; the entrypoint
         :ssl-port      8443
         :send-server-version? false
         :keystore      "ssl-certs/java_key_store"
         :key-password  ~(System/getenv "quandl_api_key")
         :ssl?          true}
  :target-path "target/%s"
  :main ^:skip-aot server.routes
  :repl-options {:timeout 300000} ; repl timeout in udoo, increase to 5 min
  :jvm-opts ~(concat ["-Duser.timezone=UTC"
                      ; Same JVM options as deploy/bin/run-job uses in production
                      "-Xms256m"
                      "-Xmx2g"
                      "-XX:MaxMetaspaceSize=512m"
                      ; https://clojure.org/reference/compilation
                      "-Dclojure.compiler.direct-linking=true"
                      ; https://stackoverflow.com/questions/28572783/no-log4j2-configuration-file-found-using-default-configuration-logging-only-er
                      "-Dlog4j.configurationFile=resources/log4j.properties"
                      ; https://stackoverflow.com/questions/4659151/recurring-exception-without-a-stack-trace-how-to-reset
                      "-XX:-OmitStackTraceInFastThrow"
                      ; https://stackoverflow.com/questions/42651420/how-to-find-non-heap-space-memory-leak-in-java
                      "-XX:-HeapDumpOnOutOfMemoryError"]
                     ; https://github.com/bhauman/lein-figwheel/issues/612
                     (let [version (System/getProperty "java.version")
                           [major _ _] (clojure.string/split version #"\.")]
                       (if (>= (Integer. major) 9)
                         ["--add-modules" "java.xml.bind"]
                         []))))
