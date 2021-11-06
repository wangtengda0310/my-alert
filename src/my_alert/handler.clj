(ns my-alert.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [clojure.data.json :as json]
            [ring.adapter.jetty9 :refer [run-jetty]])

  (:import [com.zjiecode.wxpusher.client.bean Message MessageResult]
           [com.zjiecode.wxpusher.client WxPusher]))

(declare token)

(def uids {"UID_CleiaSJQi6OfTwW7NCo91zirGP34" "wangtd"})

(defn push-weixin
  ""
  [content receiver]
  (let [message (doto (Message.)
          (.setAppToken token)
          (.setContentType Message/CONTENT_TYPE_TEXT)
          (.setContent content)
          (.setUid receiver)
          (.setUrl "http://gm.wanjubing.cn")
          )
        result (WxPusher/send message)]
    (.getMsg result)))

(defroutes app-routes
  (GET "/" [] "clojure")

  (POST "/subscribe" {body :body}
    (let [json (json/read-str (slurp body))
          data (get json "data")
          appKey (get data "appKey")
          ui (get data "uid")
          appName (get data "appName")]
      (str 123 )))

  (POST "/" [from msg]
    (cond (not from) "from null"
      :else (for [uid uids]
              (str (uid 1) (push-weixin (str msg "\n" "( "from" )") (uid 0)))
              )))

  (route/not-found "Not Found"))

(def app
  (-> app-routes
      wrap-json-body
      (wrap-defaults  api-defaults)))

(defn start-server []
  (def token (or (System/getenv "token") (slurp "token")))
  (run-jetty app {}))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (start-server)
  (println "Hello, World!"))