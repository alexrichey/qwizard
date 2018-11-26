(ns qwizard.units.drills-view
  (:require [qwizard.subs :as subs]
            [qwizard.units.drills :as unit]
            [qwizard.units.question-templates :as qts]
            [qwizard.views.language :as lang]
            [qwizard.views.diagnostic :as diag]
            [qwizard.german.helpers :as german]
            [re-frame.core :as re-frame]
            [soda-ash.core :as sa]
            [reagent.core :as r]
            [clojure.set :as set]
            [qwizard.utils :as utils]))

(defn button [name action params active?]
  [:button {:key name
            :class (if active? ["active"] [])
            :onClick (fn [e] (re-frame.core/dispatch [action params]))}
   name])

(defn chapter-dropdown []
  (let [chapter-nums (german/chapters)]
    (fn [state]
      (let [selected (:selected-chapters @state)
            chapter-vals        (map (fn [x] {:text (str "Chapter " x) :value x :key x}) chapter-nums)]
        [sa/Dropdown {:options chapter-vals
                      :placeholder "Select a chapter"
                      :selection true
                      :multiple true
                      :value (into [] selected)
                      :on-change (fn [e d]
                                   (.preventDefault e)
                                   (let [selected (into #{} (.-value d))]
                                     (swap! state assoc :selected-chapters selected)
                                     (re-frame.core/dispatch [:form-change @state])))}]))))

(defn drill-type-buttons [drill-types]
  (let [buttons (map (fn [dt] [sa/Button {} ]))]))

(defn drill-filter-form []
  (fn [unit]
    [:div {}
     ;; [sa/ButtonGroup {}
     ;;  [sa/Button {} "One"]
     ;;  [sa/ButtonOr]
     ;;  [sa/Button {} "Two"]
     ;;  [sa/ButtonOr]
     ;;  [sa/Button {} "Three"]
     ;;  ]
     ;; @state
     ;; [:div.btn-group (doall (map #(let [name (:name %)
     ;;                                    action :set-drill-type
     ;;                                    type (:type %)
     ;;                                    active? (= (:type %) (:active-type @unit))]
     ;;                                (button name action type active?))
     ;;                             (:drill-types @unit)))]
     [:br]
     [chapter-dropdown unit]]))

(defn stats []
  (fn [unit]
    (let [freqs (frequencies (map #(:got-it-correct %) (unit/get-questions @unit)))]
      [:div
       [:div (str "You're going " (or (get freqs true) 0) " for " (+ (or (get freqs true) 0) (or (get freqs false) 0)) )]
       (if (> (get freqs nil) 1) [:div {} (str ".However... you didn't try on " (dec (get freqs nil)))])])))

(defn main []
  (let [unit  (re-frame/subscribe [::subs/drills])
        filters (:filters @unit)]
    [:div {}
     [sa/Container {}
      [:div.articles-drill
       [drill-filter-form (atom filters)]
       [:div {} (str "Type: " (:active-type @unit))]
       [:div {} (str "Question " (unit/get-current-question-num @unit)
                     " Out of "  (unit/get-total-questions @unit))]
       [:div.centered {}
        [:i.fas.fa-caret-left.fa-6x.caret-left {:onClick #(re-frame.core/dispatch [:change-question :previous])}]
        [:div.up-down-carets {}
         [:i.fas.fa-thumbs-up.fa-3x.thumbs-up {:onClick #(re-frame.core/dispatch [:answer-question true])}]
         [:i.fas.fa-thumbs-down.fa-3x.thumbs-down {:onClick #(re-frame.core/dispatch [:answer-question false])}]
         ]
        [:span.question {}
         (let [question (unit/get-current-question @unit)]
           (lang/phrase (if (unit/show-answers? @unit)
                          (qts/get-answer question)
                          (qts/get-question question))))]]
       [:button.show-answer {:onClick #(re-frame.core/dispatch [:toggle-show-answers])} "Show Answer (Press Enter)"]]]
     [:br]
     ;; [diag/viewer (unit/diagnostic @unit)]
     [stats unit]
     [sa/Table {:celled true}
      [sa/TableHeader
       [sa/TableRow
        [sa/TableHeaderCell "Question"]
        [sa/TableHeaderCell "Answer"]
        [sa/TableHeaderCell "Got It?"]
        ]]
      [sa/TableBody 
       (map (fn [q] [sa/TableRow {:key (utils/rand-str)}
                     [sa/TableCell {:key (utils/rand-str)} (lang/phrase (qts/get-question q))]
                     [sa/TableCell {:key (utils/rand-str)} (lang/phrase (qts/get-answer q))]
                     [sa/TableCell {:key (utils/rand-str)} (if (:got-it-correct q)
                                                             [:i.fas.fa-check]
                                                             [:i.fas.fa-times])]
                     ])
            (rest (reverse (unit/get-questions @unit))))]]]))
