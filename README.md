# cljs-react-semantic-ui-example

Testing app to compile [React-Semantic-UI](https://react.semantic-ui.com/) with `:npm-deps`

First run, so it installs npn dependencies:
```
lein cljsbuild once
```
To start figwheel, go to `dev/user.clj`
```clojure
(start-ui!)
```
Open [http://localhost:7459/](http://localhost:7459/)

Go to `views.cljs` to see comments about what's wrong