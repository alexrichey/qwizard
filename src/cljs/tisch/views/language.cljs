(ns tisch.views.language
  (:require [re-frame.core :as re-frame]
            [tisch.german.helpers :as german]
            [tisch.units.question-templates :as questions]
            [tisch.utils :as utils]))

(def SPC {:word " " :raw? true})

(defn display-phrase-word [word language]
  (let [class (if (german/article? word) (german/article->gender (:german word)) nil)]
    [:span {:key (utils/rand-str) :class class}
     (if (:raw? word)
       (str (:word word))
       (str (get-in word [:word language])))]))

(defn phrase
  ([words]
   (let [with-spaces (interpose SPC words)]
     [:div {:key (utils/rand-str)} (map #(display-phrase-word % (:display %)) with-spaces)]))
  ([words language]
   (let [with-spaces (interpose SPC words)]
     [:div {:key (utils/rand-str)} (map #(display-phrase-word % language) with-spaces)])))


(let [rand-word (rand-nth tisch.german.dictionary/german)
      dis-word {}]
  )
