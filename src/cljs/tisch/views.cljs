(ns tisch.views
  (:require
   [re-frame.core :as re-frame]
   [tisch.db :as db]
   [tisch.subs :as subs]
   [tisch.utils :as utils]
   [tisch.lang :as lang]))

(defn word [word]
  (let [class (if (contains? db/prepositions (:name word))
                (utils/article->gender (:name word))
                nil)]
    [:span {:key (utils/rand-str) :class class} (:name word)]))

(defn phrase [words]
  (let [with-spaces (interpose {:name " "} words)]
    [:div {:key (utils/rand-str)} (map word with-spaces)]))

(defn prepositions []
  (let [dictionary (re-frame/subscribe [::subs/dictionary])
        phrases (doall (take 10 (repeatedly #(lang/make-preposition-phrase @dictionary))))]
    (map phrase phrases)))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from der Tisch!" ]
     [:div "----------"]
     [:div {} 
      (prepositions)]
     ]))
