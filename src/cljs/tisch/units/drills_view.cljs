(ns tisch.units.drills-view
  (:require [re-frame.core :as re-frame]
            [reagent.core :as r]
            [tisch.subs :as subs]
            [tisch.units.drills :as unit]
            [tisch.units.question-templates :as qts]
            [tisch.views.language :as lang]))

(defn button [name action params active?]
  [:button {:key name
            :class (if active? ["active"] [])
            :onClick (fn [e] (re-frame.core/dispatch [action params]))}
   name])

(defn drill-filter-form [unit]
  [:div {}

   [:div.btn-group
    (doall (map #(let [name (:name %)
                         action :set-drill-type
                         type (:type %)
                         active? (= (:type %) (:active-type @unit))]
                     (button name action type active?))
                  (:drill-types @unit)))]

   [:label {} "Chapter Select"]
   [:input {:type :number
            :value (unit/chapter-filter @unit)
            :onChange (fn [e] (let [num (.-value (.-currentTarget e))]
                                (re-frame.core/dispatch [:chapter-filter-num-change num])))}
    ]])

(defn main []
  (let [unit  (re-frame/subscribe [::subs/drills])]
    [:div {:class "articles-drill"}
     (drill-filter-form unit)
     [:button {:onClick #(re-frame.core/dispatch [:toggle-show-answers])} "Show Answers"]
     [:button {:onClick #(re-frame.core/dispatch [:previous-question])} "previous!"]
     [:button {:onClick #(re-frame.core/dispatch [:next-question])} "next!"]

     [:div {} (str "Type: " (:active-type @unit))]
     [:div {} (str "Question " (unit/get-current-question-num @unit)
                   " Out of "  (unit/get-total-questions @unit))]
     [:div {} (let [question (unit/get-current-question @unit)]
                (lang/phrase (if (unit/show-answers? @unit)
                                   (qts/get-answer question)
                                   (qts/get-question question))))]]))
