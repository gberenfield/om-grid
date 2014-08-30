(ns om-grid.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn grid-row-header [cursor owner]
  ;; (olog cursor)
  (om/component
    (dom/th nil
      (dom/div #js {:className "grid-column-header-label"} (:label cursor))
      (dom/div #js {:className "pear-grid-cell-header-indicators"}) ; tbd?
      (dom/div #js {:className "pear-grid-cell-header-resizable-handle"}) ; tbd?
      )))

(defn grid-col [r owner]
  (om/component (dom/td nil r)))

(defn grid-rows [row owner]
  ;; sorting row here...
  ;; (let [sorted-row (map #(get row %) (:column-order @my-testdev-grid))]
  (let [sorted-row row]
    (om/component
      (apply dom/tr nil (om/build-all grid-col sorted-row)))))

(defn om-grid [app owner]
  (reify
    om/IRenderState
    (render-state [this state]
      (dom/div #js {:className "grid-container" :style #js {:width (:width app)}}
               (dom/div #js {:className "grid-titlebar" } (:title app))
               (dom/table #js {:className "table table-striped table-bordered table-condensed"}
                 (dom/thead #js {:className ""}
                            (apply dom/tr #js {:className "om-grid-thead-tr"}
                                   (om/build-all grid-row-header (vec (sort-by #(:order %) (:columns app))))))
                 (apply dom/tbody #js {:className "om-grid-table-body"}
                        (om/build-all grid-rows (:data app))))))))
