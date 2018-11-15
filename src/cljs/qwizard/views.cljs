(ns qwizard.views
  (:require [qwizard.db :as db]
            [qwizard.subs :as subs]
            [qwizard.units.drills-view :as drills-view]
            [qwizard.views.nav :as nav]
            [re-frame.core :as re-frame]
            [reagent.core :as r]))

(defn main-panel []
  (let [current-unit-key @(re-frame/subscribe [::subs/current-unit])
        units (re-frame/subscribe [::subs/units])
        current-unit (get @units current-unit-key)]
    [:div  {:class "main" }
     [:img {:src "img/qwizard-mascot-pixilart.png"}]
     [:div {} "Ich bin das Qwizard!"]
     [:div {} "Trainiere dich selbst!"]
     ;; (nav/nav (db/units-as-list @units))
     [:h1 (str "Current Unit: " (:name current-unit)) ]
     [:div "----------"]
     [:div {:tab-index 0 :on-key-down (fn [e] (let [keycode (.-keyCode e)]
                                                (re-frame.core/dispatch [:keypress keycode])))}
      (case current-unit-key
        :drills (drills-view/main)
        [:div {} "---- no unit spec'd -----"])]]))

