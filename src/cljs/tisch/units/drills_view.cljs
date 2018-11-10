(ns tisch.units.drills-view
  (:require
   [reagent.core :as r]
   [tisch.utils :as utils]
   [tisch.german.helpers :as german]
   [tisch.german.questions :as questions]
   [tisch.german.dictionary :as dictionary]
   [tisch.views.language :as language]
   [tisch.units.drills :as drills]
   [tisch.subs :as subs]
   [re-frame.core :as re-frame]))

(defn button [name action params active?]
  [:button {:key name
            :class (if active? ["active"] [])
            :onClick (fn [e] (re-frame.core/dispatch [action params]))}
   name])

(defn drill-filter-form [unit]
  [:div {}

   [:div.btn-group
    (into [] (map #(let [name (:name %)
                         action :set-drill-type
                         type (:type %)
                         active? (= (:type %) (:active-type @unit))]
                     (button name action type active?))
                  (:drill-types @unit)))]

   [:label {} "Chapter Select"]
   [:input {:type :number
            :value (drills/chapter-filter @unit)
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
     [:div {} (str "Question " (drills/get-current-question-num @unit)
                   " Out of "  (drills/get-total-questions @unit))]
     [:div {} (let [question (drills/get-current-question @unit)]
                (language/phrase (if (drills/show-answers? @unit)
                                   (questions/get-answer question)
                                   (questions/get-question question))))]]))
