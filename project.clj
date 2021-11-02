(defproject my-alert "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.5.0"]
                 [org.clojure/data.json "1.0.0"]
                 [com.zjiecode/wxpusher-client "2.1.0"]     ;;https://gitee.com/Angious/wxpusher-client https://github.com/wxpusher/wxpusher-sdk-java/
                 [info.sunng/ring-jetty9-adapter "0.15.3"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler my-alert.handler/app :port 88}
  :main my-alert.handler/start-server
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
