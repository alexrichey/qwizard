(ns tisch.units.drills-view
  (:require
   [tisch.utils :as utils]
   [tisch.german.helpers :as german]
   [tisch.german.questions :as questions]
   [tisch.german.dictionary :as dictionary]
   [tisch.views.language :as language]
   [tisch.units.drills :as drills]
   [tisch.subs :as subs]
   [re-frame.core :as re-frame]))

(defn main []
  (let [unit  (re-frame/subscribe [::subs/drills])]
    [:div {:class "articles-drill"}
     [:button {:onClick #(re-frame.core/dispatch [:toggle-show-answers])} "Show Answers"]
     [:button {:onClick #(re-frame.core/dispatch [:previous-question])} "previous!"]
     [:button {:onClick #(re-frame.core/dispatch [:next-question])} "next!"]
     [:input {:type :number
              :value (:chapter-filter @unit)
              :onChange (fn [e] (let [num (.-value (.-currentTarget e))]
                                  (re-frame.core/dispatch [:chapter-filter-num-change num])))}]
     [:div {} (str "Question " (drills/get-current-question-num @unit)
                   " Out of "  (drills/get-total-questions @unit))]
     [:div {} (let [question (drills/get-current-question @unit)]
                (language/phrase (if (drills/show-answers? @unit)
                                   (questions/get-answer question)
                                   (questions/get-question question))))]]))
