(ns tisch.views
  (:require
   [re-frame.core :as re-frame]
   [tisch.db :as db]
   [reagent.core :as r]
   [tisch.subs :as subs]
   [tisch.views.nav :as nav]
   [tisch.units.drills-view :as drills-view]))

(defn main-panel []
  (print "rerendering all")
  (let [current-unit-key @(re-frame/subscribe [::subs/current-unit])
        units (re-frame/subscribe [::subs/units])
        current-unit (get @units current-unit-key)]
    [:div  {:class "main" }
     (nav/nav (db/units-as-list @units))
     [:h1 (str "Current Unit: " (:name current-unit)) ]
     [:div "----------"]
     [:div {:tab-index 0 :on-key-down (fn [e] (let [keycode (.-keyCode e)]
                                                 (re-frame.core/dispatch [:keypress keycode])))}
      (case current-unit-key
        :drills (drills-view/main)
        [:div {} "---- no unit spec'd -----"])]]))

