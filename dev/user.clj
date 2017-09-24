(ns user
  (:require [figwheel-sidecar.repl-api]))

(defn start-ui! []
  (figwheel-sidecar.repl-api/start-figwheel!
    (-> (figwheel-sidecar.config/fetch-config)
        (assoc-in [:data :all-builds 0 :build-options :install-deps] false))
    "dev")
  (figwheel-sidecar.repl-api/cljs-repl "dev"))

(comment
  (start-ui!))