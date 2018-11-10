(ns tisch.views
  (:require
   [re-frame.core :as re-frame]
   [tisch.db :as db]
   [tisch.subs :as subs]
   [tisch.german.dictionary :as dictionary]
   [tisch.german.helpers :as german]
   [tisch.units.drills :as drills-helper]
   [tisch.utils :as utils]
   [tisch.views.language :as language]
   [tisch.views.templates :as templates]
   [tisch.units.drills :as drills]
   [tisch.german.questions :as questions]))

;; nav
(defn nav-unit-button [unit]
  [:button {:key (:key unit)
            :onClick #(re-frame.core/dispatch [:change-unit (:key unit)])}
   (:name unit)])

(defn nav [units]
  (map nav-unit-button units))

(defn drills []
  (let [unit  (re-frame/subscribe [::subs/drills])]
    [:div {:class "articles-drill"}
     [:input {:type :number
              :value (:chapter-filter @unit)
              :onChange (fn [e] (let [num (.-value (.-currentTarget e))]
                                  (re-frame.core/dispatch [:chapter-filter-num-change num])))}]
     [:div {} (str "Question " (drills-helper/get-current-question-num @unit)
                   " Out of "  (drills-helper/get-total-questions @unit))]

     [:div {} (let [question (drills-helper/get-current-question @unit)
                    phrase (if (drills/show-answers? @unit)
                                         (questions/get-answer question)
                                         (questions/get-question question))]
                (language/phrasex phrase))]
     ;; [:div {} (str @unit)]
     ]))

(defn articles-drill []
  (let [dictionary  dictionary/german
        unit  (re-frame/subscribe [::subs/article-drills])
        nouns (:vocab @unit)
        current-word (get (:vocab @unit) (:current-word-index @unit))
        current-word-with-article (vector (german/lookup-article (:article current-word)) current-word)]
    [:div {:class "articles-drill"}
     [:input {:type :number
              :value (:chapter-filter @unit)
              :onChange (fn [e] (let [num (.-value (.-currentTarget e))]
                                  (re-frame.core/dispatch [:chapter-filter-num-change num])))}]
     [:div {} (str "total words: " (count nouns))]
     [:button {:onClick #(re-frame.core/dispatch [:toggle-show-answers])} "Show Answers"]
     [:button {:onClick #(re-frame.core/dispatch [:previous-question])} "previous!"]
     [:button {:onClick #(re-frame.core/dispatch [:next-question])} "next!"]
     ;; [:div {} (article-drill-phrase current-word-with-article (:show-answers @unit))]
     ;; [:div {} (str @unit)]
     ]))

(defn vocab-drills []
  (let [drills (re-frame/subscribe [::subs/vocab-drills])]
    [:div {}
     [:div {} (map
               (fn [x] [:div {:key (utils/rand-str)} (str (:article x) " " (:german x))])
               (:vocab @drills))]]))


(defn main-panel []
  (let [current-unit-key @(re-frame/subscribe [::subs/current-unit])
        units (re-frame/subscribe [::subs/units])
        current-unit (get @units current-unit-key)]
    [:div  {:class "main" }
     (nav (db/units-as-list @units))
     [:h1 (str "Current Unit: " (:name current-unit)) ]
     [:div "----------"]
     [:div {:tab-index 0 :on-key-down (fn [e] (let [keycode (.-keyCode e)]
                                                 (re-frame.core/dispatch [:keypress keycode])))}
      (case current-unit-key
        :drills (drills)
        [:div {} "---- no unit spec'd -----"])]])) 

