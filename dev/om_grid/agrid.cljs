(ns dev.agrid
  (:require [om-grid.core :refer [om-grid]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [om-grid.utils :refer [sample-data olog]]))

(defn gstate []
  {:columns ; type is :text, :number, :date (for sorting cols)
   [{:label "Name" :name :name :width 100 :type :text :align :center :order 0}
    {:label "Test" :name :test :width 100 :type :text :align :center :order 3}
    {:label "Address" :name :address :width 200 :type :text :align :center :order 1}]
   ;; then to get columns in order, simply do state (vec (sort-by #(:order %) (:columns gstate)))
   :data (sample-data 10)
   ;; use (map #(:name %) (vec (sort-by #(:order %) (:columns gstate)))) for a seq of names in the order  to render data
   :config {:AllowColumnResize true :ShowCellBorder true :AllowAlternateRowHighlight true}
   :width 950 :title "My Test Grid"
   ;; :events {:on-column-resize
   ;;          ;; (fn [e] (.refreshOnColumnResize (.-currentTarget e)))}
   ;;          (fn [e] nil)}
   })

(def my-testdev-grid (atom
                       (assoc (gstate) :column-order (map #(:name %) (vec (sort-by #(:order %) (:columns (gstate))))))))

(defn gridit []
  (om/root
    om-grid
    my-testdev-grid
    {:target (. js/document (getElementById "here"))}))

(gridit)

(comment
  (gridit)
  (swap! my-testdev-grid assoc-in [:data 200 :name] "summat new" )
  (prn (:data  @my-testdev-grid))
  (olog (dom/div nil "hi!"))
  (olog (create-grid @my-testdev-grid))
  (swap! my-testdev-grid assoc-in [:data 0 :name] "Robert Okrasinski" )
  (js/parseInt "A0" 16)
  )

; test use of om-pear here! get brepl working first
