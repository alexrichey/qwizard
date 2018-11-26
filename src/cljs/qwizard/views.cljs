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
     [sa/Menu (doall (map (fn [x]
                            [sa/MenuItem {:name (:name x) :active false :key (:name x)}])
                          (vals @units)))]
     [:div {:on-key-down (fn [e]
                           (let [keycode (.-keyCode e)]
                             (.preventDefault e)
                             (re-frame.core/dispatch [:keypress keycode])))}
      (case current-unit-key
        :drills [drills-view/main])]

     [:div#footer
      [sa/Grid {:columns 12}
       [sa/GridRow
        [sa/GridColumn {:width 3}
         [:img {:src "img/qwizard-mascot-pixilart.png"}]]
        [sa/GridColumn {:width 9}
         [:div.qwizard-says
          [:div "Ich bin das Qwizard!"]
          [:div "Trainiere dich selbst!"]]]]]]]))


