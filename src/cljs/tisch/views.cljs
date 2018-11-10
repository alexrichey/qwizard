(ns tisch.views
  (:require
   [re-frame.core :as re-frame]
   [tisch.db :as db]
   [tisch.subs :as subs]
   [tisch.german.dictionary :as dictionary]
   [tisch.german.helpers :as german]
   [tisch.utils :as utils]
   [tisch.views.nav :as nav]
   [tisch.views.language :as language]
   [tisch.views.templates :as templates]
   [tisch.units.drills :as drills]
   [tisch.units.drills-view :as drills-view]
   [tisch.german.questions :as questions]))

(defn main-panel []
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

