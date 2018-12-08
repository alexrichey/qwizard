(ns qwizard.views
  (:require [qwizard.db :as db]
            [qwizard.subs :as subs]
            [qwizard.units.drills-view :as drills-view]
            [qwizard.views.nav :as nav]
            [soda-ash.core :as sa]
            [re-frame.core :as re-frame]
            [reagent.core :as r]))

(defn main-panel []
  (let [current-unit-key @(re-frame/subscribe [::subs/current-unit])
        units (re-frame/subscribe [::subs/units])
        current-unit (get @units current-unit-key)]

    [:div.main
     [sa/Menu (doall (map (fn [unit]
                            (let [is-active? (= (:key unit) current-unit-key)]
                              [sa/MenuItem {:name (:name unit) :active is-active? :key (:name unit)}]))
                          (vals @units)))
      [sa/MenuItem {:position :right} [:img.qwizard {:src "img/qwizard-mascot-pixilart.png"}]]]
     [:div {:on-key-down (fn [e]
                           (let [keycode (.-keyCode e)]
                             (.preventDefault e)
                             (re-frame.core/dispatch [:keypress keycode])))}
      (case current-unit-key
        :drills [drills-view/main])]]))


