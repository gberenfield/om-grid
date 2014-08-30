(defproject om-grid "0.1.0-SNAPSHOT"
  :description "Pear-Grid example for om-pear"
  :url "https://github.com/gberenfield/om-pear"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/tools.reader "0.8.1"]
                 [org.clojure/core.async "0.1.338.0-5c5012-alpha"]
                 [om "0.7.1"]]
  :source-paths ["src"]
  :profiles
  {:dev {:source-paths ["src" "dev"]
         :dependencies [[com.cemerick/piggieback "0.1.3"]
                        [weasel "0.4.0-SNAPSHOT"]
                        [figwheel "0.1.4-SNAPSHOT"]]
         ;; :clean-res "resources/public/js/out"
         ;; :clean-targets *{:protect false} [:target-path :clean-res "out"]
         :clean-targets ^{:protect false} ["out" "resources/public/js/out"]
         :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
         :plugins [[com.cemerick/austin "0.1.5"]
                   [lein-figwheel "0.1.4-SNAPSHOT"]
                   [lein-cljsbuild "1.0.4-SNAPSHOT"]]}
   :build {:source-paths ["src"]}}
  :aliases {"ex" ["with-profile" "build" "do"
                  "cljsbuild" "clean,"
                  "cljsbuild" "once" "a"]}
  :cljsbuild
  {:builds [{:id "dev"
             :source-paths ["src" "dev"]
             :compiler {:output-to "resources/public/js/out/om-grid.js"
                        :output-dir "resources/public/js/out"
                        :source-map "resources/public/js/om-grid.js.map"
                        :optimizations :none}}]}
  )
