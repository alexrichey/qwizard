(ns tisch.views.language
  (:require
   [re-frame.core :as re-frame]
   [tisch.german :as german]
   [tisch.utils :as utils]
   [tisch.questions :as questions]
   [tisch.lang :as lang]))

(defn word [word language]
  (let [class (if (german/article? word) (utils/article->gender (:german word)) nil)]
    [:span {:key (utils/rand-str) :class class}
     (if (:raw? word)
       (str (:word word))
       (str (get-in word [:word language])))]))

(defn phrase [words language]
  (let [with-spaces (interpose {:word " " :raw? true} words)]
    [:div {:key (utils/rand-str)} (map #(word % language) with-spaces)]))


(defn phrasex [words]
  (let [with-spaces (interpose {:word " " :raw? true} words)]
    [:div {:key (utils/rand-str)} (map #(word % (:display %)) with-spaces)]))