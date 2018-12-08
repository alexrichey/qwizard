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

(def QUESTION-HISTORY-MAX-ROWS 20)

(defn chapter-dropdown []
  (let [chapter-nums (german/chapters)]
    (fn [state]
      (let [selected-chapters (:selected-chapters @state)
            chapter-vals      (map (fn [x] {:text (str "Chapter " x) :value x :key x}) chapter-nums)]
        [sa/Dropdown {:options chapter-vals
                      :placeholder "Select a chapter"
                      :selection true
                      :multiple true
                      :value (into [] selected-chapters)
                      :on-change (fn [e data]
                                   (.preventDefault e)
                                   (let [new-selected-chapters (into #{} (.-value data))]
                                     (swap! state assoc :selected-chapters new-selected-chapters)
                                     (re-frame.core/dispatch [:form-change @state])))}]))))

(defn drill-type-buttons []
  (fn [unit]
    [sa/ButtonGroup {:class "btn-group"}
     (doall (map (fn [{drill-name :name drill-type :type}]
                   [sa/Button {:key (utils/rand-str)
                               :color :teal 
                               :active (= drill-type (:active-type @unit))
                               :on-click (fn [e]
                                           (.preventDefault e)
                                           (re-frame.core/dispatch [:set-drill-type drill-type]))}
                    drill-name])
                 (:drill-types @unit)))]))

(defn question-container []
  (fn [unit]
    (let [question-template (unit/get-current-question @unit)
          answer (qts/get-answer question-template)
          question (qts/get-question question-template)]
      [sa/Card
       [sa/CardHeader "Translate Please!"]
       [sa/CardContent [sa/Reveal {:animated "small fade"}
                        (when (not (unit/show-answers? @unit))
                          [sa/RevealContent {:visible true} [:div.question-cover (lang/phrase question)]])
                        [sa/RevealContent {:hidden true} [:div (lang/phrase answer)]]]]])))

(defn main-question-panel []
  (fn [unit]
    [sa/Container {:tab-index 0}
       [:div.articles-drill
        [drill-type-buttons unit]
        [:div
         [chapter-dropdown (atom (:filters @unit))]]
        [question-container unit]
        (comment
         [:div (str "Question " (unit/get-current-question-num @unit))]
         [:div.centered
          [:i.fas.fa-caret-left.fa-6x.caret-left {:onClick #(re-frame.core/dispatch [:change-question :previous])}]
          [:div.up-down-carets
           [:div "yep." [:i.fas.fa-thumbs-up.fa-3x.thumbs-up {:onClick #(re-frame.core/dispatch [:answer-question true])}]]
           [:br]
           [:div "nope"
            [:i.fas.fa-thumbs-down.fa-3x.thumbs-down {:onClick #(re-frame.core/dispatch [:answer-question false])}]]]
          [:span.question
           [question-container unit]
           (let [question (unit/get-current-question @unit)]
             (lang/phrase (if (unit/show-answers? @unit)
                            (qts/get-answer question)
                            (qts/get-question question))))]])
        (comment [:button.show-answer {:onClick #(re-frame.core/dispatch [:toggle-show-answers])} "Show Answer (Press Enter)"])]]))

(defn stats []
  (fn [unit]
    (let [freqs (frequencies (map #(:got-it-correct %) (unit/get-questions @unit)))]
      [:div
       [:div (str "You're going " (or (get freqs true) 0) " for " (+ (or (get freqs true) 0) (or (get freqs false) 0)) )]
       (if (> (get freqs nil) 1) [:div (str "However... you didn't try on " (dec (get freqs nil)))])])))

(defn answers-table []
  (fn [unit]
    [sa/Table {:celled true}
     [sa/TableHeader
      [sa/TableRow
       [sa/TableHeaderCell "Question"]
       [sa/TableHeaderCell "Answer"]
       [sa/TableHeaderCell "Got It?"]]]
     [sa/TableBody
      (map (fn [q] [sa/TableRow {:key (utils/rand-str)}
                    [sa/TableCell {:key (utils/rand-str)} (lang/phrase (qts/get-question q))]
                    [sa/TableCell {:key (utils/rand-str)} (lang/phrase (qts/get-answer q))]
                    [sa/TableCell {:key (utils/rand-str)} (if (:got-it-correct q)
                                                            [:i.fas.fa-check]
                                                            [:i.fas.fa-times])]])
           (rest (take QUESTION-HISTORY-MAX-ROWS (reverse (unit/get-questions @unit)))))]]))

(defn main []
  (fn []
    (let [unit (re-frame/subscribe [::subs/drills])]
     [:div
      [main-question-panel unit]
      [stats unit]
      [answers-table unit]
      ;; [diag/viewer (unit/diagnostic @unit)]
      ])))
