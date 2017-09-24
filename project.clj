(defproject cljs-react-semantic-ui-example "0.1.0-SNAPSHOT"
  :dependencies [[medley "1.0.0"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.930"]
                 [print-foo-cljs "2.0.3"]
                 [re-frame "0.10.1"]
                 [reagent "0.8.0-alpha1"]]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]
             :server-port 7459}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.4"]
                   [com.cemerick/piggieback "0.2.1"]
                   [figwheel-sidecar "0.5.13"]
                   [org.clojure/tools.nrepl "0.2.13"]]
    :plugins [[lein-figwheel "0.5.13"]]}}

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src/cljs"]
                :figwheel {:on-jsload "cljs-react-semantic-ui-example.core/mount-root"}
                :compiler {:main cljs-react-semantic-ui-example.core
                           :output-to "resources/public/js/compiled/app.js"
                           :output-dir "resources/public/js/compiled/out"
                           :asset-path "js/compiled/out"
                           :source-map-timestamp true
                           :preloads [print.foo.preloads.devtools]
                           :external-config {:devtools/config {:features-to-install :all}}
                           :install-deps true
                           :npm-deps {:semantic-ui-react "0.73.1"
                                      :react "15.6.1"
                                      :react-dom "15.6.1"}}}

               {:id "min"
                :source-paths ["src/cljs"]
                :compiler {:main cljs-react-semantic-ui-example.core
                           :output-to "resources/public/js/compiled/app.js"
                           :optimizations :advanced
                           :closure-defines {goog.DEBUG false}
                           :pretty-print false
                           :closure-warnings {:global-this :off}
                           :npm-deps {:semantic-ui-react "0.73.1"
                                      :react "15.6.1"
                                      :react-dom "15.6.1"}}}]}

  )
