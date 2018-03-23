(defproject compojure "0.1.0"
  :uberjar-name "app.jar"
  :repositories {"atlassian" {:url "https://maven.atlassian.com/content/repositories/atlassian-3rdparty/"}}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [clj-http "3.7.0"]
                 [clj-time "0.14.2"]
                 [com.amazonaws.athena.jdbc/AthenaJDBC41 "1.0.1-atlassian-hosted"]
                 [compojure "1.5.1" :exclusions [ring/ring-core]]
                 [de.ubercode.clostache/clostache "1.3.1"]
                 [environ "1.1.0"]
                 [hiccup "1.0.5"]
                 [jarohen/chime "0.2.2"]
                 [markdown-clj "0.9.99"]
                 [net.sf.uadetector/uadetector-resources "2013.02"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/java.jdbc "0.7.3"]
                 [org.clojure/tools.logging "0.4.0"]
                 [org.postgresql/postgresql "42.1.4"]
                 [org.slf4j/slf4j-log4j12 "1.6.4"]
                 [ring "1.6.3"]
                 [ring/ring-anti-forgery "1.1.0"]
                 [ring/ring-defaults "0.3.1" ]
                 [ring/ring-json "0.4.0"]
                 [venantius/ultra "0.5.1" :exclusions [instaparse]]
                 ; cljs
                 [org.clojure/clojurescript "1.9.946"]
                 [binaryage/devtools "0.9.9"]
                 [cljsjs/jquery "2.1.4-0"]
                 [cljsjs/react "15.6.2-4"]
                 [cljsjs/react-dom "15.6.2-4"]
                 [re-frame "0.10.5"]
                 [reagent "0.7.0"]]
  :plugins [[lein-cloverage "1.0.10"]
            [lein-cljsbuild "1.1.7"]]
  :source-paths ["src"]
  :clean-targets ^{:protect false} ["resources/public/js"]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds {:app {:source-paths ["src-cljs"]
                             :compiler {:asset-path    "js/out"
                                        :main          "app.core"
                                        :output-dir    "resources/public/js/out"
                                        :output-to     "resources/public/js/app.js"}}}}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]
                   :plugins [[lein-cljfmt "0.5.7"]
                             [lein-environ "1.1.0"]
                             [lein-figwheel "0.5.14"]
                             [lein-ring "0.12.0"]]
                   :figwheel {:css-dirs ["resources/public/css"]
                              :ring-handler server.routes/app
                              :server-port 8081}
                   :cljsbuild {:builds {:app {:figwheel true
                                              :compiler {:optimizations :none
                                                         :preloads      [devtools.preload]
                                                         :pretty-print  true
                                                         :source-map    true
                                                         :external-config {:devtools/config {:features-to-install :all}}}}}}}
             :uberjar {:aot :all
                       :cljsbuild {:builds {:app {:compiler {:closure-defines {goog.DEBUG false}
                                                             :optimizations :advanced
                                                             :pretty-print  false}}}}}}
  :ring {:handler       server.routes/app  ; lein ring server uses this as
         :port          8080               ; the entrypoint
         :ssl-port      8443
         :send-server-version? false
         :keystore      "ssl-certs/java_key_store"
         :key-password  ~(System/getenv "quandl_api_key")
         :ssl?          true}
  :target-path "target/%s"
  :main ^:skip-aot server.routes
  :jvm-opts ["-Duser.timezone=UTC"
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
             "-XX:-HeapDumpOnOutOfMemoryError"])
