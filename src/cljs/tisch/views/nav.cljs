(ns tisch.views.nav)

(defn nav-unit-button [unit]
  [:button {:key (:key unit)
            :onClick #(re-frame.core/dispatch [:change-unit (:key unit)])}
   (:name unit)])

(defn nav [units]
  (map nav-unit-button units))
