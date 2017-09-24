(ns cljs-react-semantic-ui-example.core
  (:require
    [reagent.core :as reagent]
    [re-frame.core :as re-frame]
    [cljs-react-semantic-ui-example.events]
    [cljs-react-semantic-ui-example.subs]
    [cljs-react-semantic-ui-example.views :as views]
    [cljs-react-semantic-ui-example.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))