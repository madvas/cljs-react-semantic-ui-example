(ns cljs-react-semantic-ui-example.events
  (:require [re-frame.core :as re-frame]
            [cljs-react-semantic-ui-example.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
