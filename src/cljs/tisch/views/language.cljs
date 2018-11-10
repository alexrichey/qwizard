(ns tisch.views.language
  (:require
   [re-frame.core :as re-frame]
   [tisch.german.helpers :as german]
   [tisch.utils :as utils]
   [tisch.german.questions :as questions]))

(defn word [word language]
  (let [class (if (german/article? word) (german/article->gender (:german word)) nil)]
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

;; old
;; (defn word [word]
;;   (let [class (if (german/article? word) (german/article->gender (:german word)) nil)]
;;     [:span {:key (utils/rand-str) :class class} (:german word)]))

;; (defn english-word [word]
;;   [:span {:key (utils/rand-str)} (:english word)])

;; (defn phrase [words]
;;   (let [with-spaces (interpose {:german " "} words)]
;;     [:div {:key (utils/rand-str)} (map word with-spaces)]))

;; (defn prepositions []
;;   (let [dictionary dictionary/german
;;         phrases (doall (take 10 (repeatedly #(lang/make-preposition-phrase))))]
;;     (map phrase phrases)))
