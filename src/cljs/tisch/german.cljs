(ns tisch.german
  (:require [tisch.dictionary :as dictionary]))

(defn noun? [word]
  (= (:type word) :noun))

(defn nouns []
  (into [] (filter noun? (:things dictionary/german))))

(defn lookup-article [article]
  (first (filter #(= (:name %) article) (:articles dictionary/german))))

(defn article->prep-article [article]
  (assoc article :name (get article :as-preposition)))

(def ist {:name "ist" :english "is"})

(def prepositions #{"der" "die" "das" "den"})
