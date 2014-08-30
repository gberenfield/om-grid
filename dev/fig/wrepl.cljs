(ns fig.wrepl
  (:require [figwheel.client :as fw :include-macros true]
            [clojure.browser.repl :as repl]))


(enable-console-print!)

(fw/watch-and-reload
  ;; :websocket-url "ws:localhost:3449/figwheel-ws" default
  :jsload-callback
  (fn []
    (js/console.log (str (gensym "R"))))) 

(repl/connect "http://localhost:9000/repl")
