(ns qwizard.units.drills-view
  (:require [qwizard.subs :as subs]
            [qwizard.units.drills :as unit]
            [qwizard.units.question-templates :as qts]
            [qwizard.views.language :as lang]
            [qwizard.german.helpers :as german]
            [re-frame.core :as re-frame]
            [soda-ash.core :as sa]
            [reagent.core :as r]))

(defn button [name action params active?]
  [:button {:key name
            :class (if active? ["active"] [])
            :onClick (fn [e] (re-frame.core/dispatch [action params]))}
   name])

(defn chapter-dropdown []
  (let [chapter-nums (german/chapters)
        chapter-vals (map (fn [x] {:text (str "Chapter " x) :value x :key x}) chapter-nums)]
    (fn [state]
      [sa/Dropdown {:options chapter-vals
                    :placeholder "Select a chapter"
                    :selection true
                    :multiple true
                    :on-change (fn [e d]
                                 (.preventDefault e)
                                 (let [selected (into #{} (.-value d))]
                                   (swap! state assoc :selected-chapters selected)
                                   (re-frame.core/dispatch [:form-change @state])))}])))

(defn drill-filter-form []
  (let [state (r/atom {})]
    (fn [unit]
      [:div {}
       ;; @state
       [:div.btn-group (doall (map #(let [name (:name %)
                                          action :set-drill-type
                                          type (:type %)
                                          active? (= (:type %) (:active-type @unit))]
                                      (button name action type active?))
                                   (:drill-types @unit)))]
       [:br]
       [chapter-dropdown state]])))

(defn main []
  (print "rerendered main")
  (let [unit  (re-frame/subscribe [::subs/drills])
        filters (:filters @unit)]
    [:div {:class "articles-drill"}
     [drill-filter-form (atom filters)]
     [:button {:onClick #(re-frame.core/dispatch [:toggle-show-answers])} "Show Answers"]
     [:button {:onClick #(re-frame.core/dispatch [:change-question :previous])} "previous!"]
     [:button {:onClick #(re-frame.core/dispatch [:change-question :next])} "next!"]

     [:div {} (str "Type: " (:active-type @unit))]
     [:div {} (str "Question " (unit/get-current-question-num @unit)
                   " Out of "  (unit/get-total-questions @unit))]
     [:div {} (let [question (unit/get-current-question @unit)]
                (lang/phrase (if (unit/show-answers? @unit)
                                   (qts/get-answer question)
                                   (qts/get-question question))))]]))
