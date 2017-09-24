(ns cljs-react-semantic-ui-example.views
  (:require
    [re-frame.core :as re-frame]
    ["semantic-ui-react/dist/commonjs" :as ui]
    ["semantic-ui-react/dist/commonjs/modules/Transition/Transition" :as transition]
    ["semantic-ui-react/dist/commonjs/modules/Transition/TransitionGroup" :as transition-group]
    ;["semantic-ui-react/dist/commonjs/lib/META" :as meta]
    [reagent.core :as r]))

(def divider (r/adapt-react-class ui/Divider))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        visible? (r/atom true)]
    (fn []
      [:div
       [:div "Hello from  " @name]
       [divider]])))

;; Run in REPL
(comment
  ;; :Label is nil, because it imports Image and it imports Label again
  ;; either :Transition or :TransitionGroup is nil, because they import each other
  ui

  transition
  transition-group
  )

;; App also throws error: Uncaught ReferenceError: META is not defined
;; which I found issue about here https://github.com/google/closure-compiler/issues/2585
;; but solution is not known to me. This error doesn't seem to break app on dev compilation,
;; but it breaks app on advanced compilation.
