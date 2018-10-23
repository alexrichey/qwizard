(ns tisch.views
  (:require
   [re-frame.core :as re-frame]
   [tisch.db :as db]
   [tisch.subs :as subs]
   [tisch.utils :as utils]
   [tisch.lang :as lang]))

;; sentence structure
(defn word [word]
  (let [class (if (contains? db/prepositions (:name word))
                (utils/article->gender (:name word))
                nil)]
    [:span {:key (utils/rand-str) :class class} (:name word)]))

(defn english-word [word]
  [:span {:key (utils/rand-str)} (:english word)])

(defn phrase [words]
  (let [with-spaces (interpose {:name " "} words)]
    [:div {:key (utils/rand-str)} (map word with-spaces)]))

(defn prepositions []
  (let [dictionary (re-frame/subscribe [::subs/dictionary])
        phrases (doall (take 10 (repeatedly #(lang/make-preposition-phrase @dictionary))))]
    (map phrase phrases)))


;; nav
(defn nav-unit-button [unit]
  [:button {:key (:key unit)
            :onClick #(re-frame.core/dispatch [:change-unit (:key unit)])}
   (:name unit)])

(defn nav [units]
  (map nav-unit-button units))

(defn article-drill-phrase [words show-answers]
  (let [with-spaces (interpose {:name " "} words)]
    [:div {:key (utils/rand-str)}
     (english-word (second words))

     (if show-answers "      -> ")
     (if show-answers (word (first words)))
     " "
     (if show-answers (word (second words)))
     ]))

(defn articles-drill []
  (let [dictionary  (re-frame/subscribe [::subs/dictionary])
        unit  (re-frame/subscribe [::subs/article-drills])
        nouns (db/nouns @dictionary)
        nouns-with-articles (map #(vector (db/lookup-article @dictionary (:article %))
                                          %)
                                 nouns)]
    [:div {}
     [:button {:onClick #(re-frame.core/dispatch [:toggle-show-answers])} "Show Answers"]
     [:button {:onClick #(re-frame.core/dispatch [:shuffle-questions])} "Shuffle"]
     [:div {} (str "showing answers? " (:show-answers @unit) )]
     (doall (map #(article-drill-phrase % (:show-answers @unit)) nouns-with-articles))]))

(defn vocab-drills []
  (let [dictionary  (re-frame/subscribe [::subs/dictionary])
        drills (re-frame/subscribe [::subs/vocab-drills])]
    [:div {}
     [:div {} (map
               (fn [x] [:div {:key (utils/rand-str)} (str (:article x) " " (:name x))])
               (:vocab @drills))]]))


;; main
(def unit-components {:preposition-phrases prepositions
                      :vocab-drills vocab-drills})

(defn main-panel []
  (let [current-unit-key @(re-frame/subscribe [::subs/current-unit])
        units (re-frame/subscribe [::subs/units])
        current-unit (get @units current-unit-key)]
    [:div
     (nav (db/units-as-list @units))
     [:h1 (str "Current Unit: " (:name current-unit)) ]
     [:div "----------"]
     [:div {}
      (case current-unit-key
        :vocab-drills (vocab-drills)
        :articles-drill (articles-drill)
        :preposition-phrases (prepositions))]]))
;;(re-frame.core/dispatch [:init-vocab-drills {}])
