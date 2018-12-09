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

(defn modal-example []
  (fn []
    [sa/Modal {:trigger (r/as-element [sa/Button "Show Modal"])}
     [sa/ModalHeader "Select a Photo"]
     [sa/ModalContent {:image true}
      [sa/Image {:wrapped true
                 :size    "medium"
                 :src     "http://semantic-ui.com/images/avatar2/large/rachel.png"}]
      [sa/ModalDescription
       [sa/Header "Default Profile Image"]
       [:p "We've found the following gravatar image associated with your e-mail address."]
       [:p "Is it okay to use this photo?"]]]]))

(defn question-container []
  (fn [unit]
    (let [question-template (unit/get-current-question @unit)
          answer (qts/get-answer question-template)
          question (qts/get-question question-template)]
      [sa/Card
       [sa/CardHeader "Translate Please!"]
       [sa/CardContent {:class "card-question-body"}
        [sa/Reveal {:animated "small fade"}
         (when (not (unit/show-answers? @unit))
           [sa/RevealContent {:visible true} [:div.question-cover
                                              [:div "Question: "]
                                              [:div (lang/phrase question)]]])
         [sa/RevealContent {:hidden true} [:div
                                           [:div "Answer: "]
                                           [:div (lang/phrase answer)]]]]]])))

(defn drills-info []
  (let [controls ["Up / k"      "Got it. Mark the Question as Correct!"
                  "Down / j"    "Nope. Whiff. Wrong."
                  "Right / l"   "Skip the Question"
                  "Left / h"    "Go back"
                  "Enter / tab" "Show the Answer"]]
   (fn []
     [:div {:style {:padding "20px"}}
      [:img {:style {:height "100px"} :src "img/qwizard-mascot-pixilart.png"}] [:span "Guten Tag!"]
      [:div {:style {:margin-top "20px"}}]
      [:h4 "Directions:"]
      [:div (str "Use the buttons to indicate whether you knew the answer. \n"
                "Or use the controls below (that's how the cool kids do it)")]
      [sa/Table
       [sa/TableHeader
        [sa/TableRow
         [sa/TableHeaderCell "Key"]
         [sa/TableHeaderCell "What It Does"]]]
       [sa/TableBody
        (doall (map
                (fn [x]
                  [sa/TableRow {:key (utils/rand-str)}
                   [sa/TableCell (str (first x))]
                   [sa/TableCell (str (second x))]])
                (partition 2 controls)))]]])))

(defn drills-modal []
  (fn [unit]
    [sa/Modal {:defaultOpen (:show-controls-on-init unit)
               :close-icon true
               :on-close #(re-frame.core/dispatch [:disable-control-modal-auto-open])
               :content (r/as-element [drills-info])
               :trigger (r/as-element [:i.fa.fa-info-circle {}])}]))

(defn control-buttons []
  (fn []
    [:div {:style {:text-align "center"}}
     [:i.fa.fa-check-circle.fa-2x {:style {:color "green" :margin-right "10px"}
                                   :onClick #(re-frame.core/dispatch [:answer-question true])}]
     [:i.fas.fa-times.fa-2x {:style {:color "red"}
                             :onClick #(re-frame.core/dispatch [:answer-question false])}]]))

(defn stats []
  (fn [unit]
    (let [freqs (frequencies (map #(:got-it-correct %) (unit/get-questions @unit)))]
      [:div
       [:div (str "You're going " (or (get freqs true) 0) " for " (+ (or (get freqs true) 0) (or (get freqs false) 0)) )]
       (if (> (get freqs nil) 1) [:div (str "However... you didn't try on " (dec (get freqs nil)))])])))

(defn main-question-panel []
  (fn [unit]
    [sa/Container {:tab-index 0}
       [:div.articles-drill
        [drill-type-buttons unit]
        [:div.info-icon-container [drills-modal @unit]]
        [:div [chapter-dropdown (atom (:filters @unit))]]
        [question-container unit]
        [control-buttons]
        [stats unit]]]))


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
      [answers-table unit]
      ;; [diag/viewer (unit/diagnostic @unit)]
      ])))
