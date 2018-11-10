(ns tisch.views.language
  (:require
   [re-frame.core :as re-frame]
   [tisch.german.helpers :as german]
   [tisch.utils :as utils]
   [tisch.german.questions :as questions]))

(def SPC {:word " " :raw? true})

(defn word [word language]
  (let [class (if (german/article? word) (german/article->gender (:german word)) nil)]
    [:span {:key (utils/rand-str) :class class}
     (if (:raw? word)
       (str (:word word))
       (str (get-in word [:word language])))]))

(defn phrase
  ([words]
   (let [with-spaces (interpose SPC words)]
     [:div {:key (utils/rand-str)} (map #(word % (:display %)) with-spaces)]))
  ([words language]
   (let [with-spaces (interpose SPC words)]
     [:div {:key (utils/rand-str)} (map #(word % language) with-spaces)])))
