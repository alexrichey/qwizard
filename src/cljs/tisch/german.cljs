(ns tisch.german
  (:require [tisch.dictionary :as dictionary]))

;; filters
(defn article? [word]
  (= (:type word) :article))

(defn noun? [word]
  (= (:type word) :noun))

(defn preposition? [word]
  (= (:type word) :preposition))

(defn chapter? [word chapter]
  (= (:chapter word) chapter))


;; getters
(defn articles []
  (into [] (filter article? dictionary/german)))

(defn nouns []
  (into [] (filter noun? dictionary/german)))

(defn prepositions []
  (into [] (filter preposition? dictionary/german)))

(defn words-for-chapter [chapter]
  (into [] (filter #(chapter? % chapter)) dictionary/german))

;; helpers
(defn lookup-article [article]
  (first (filter #(= (:name %) article) (articles))))

(defn article->prep-article [article]
  (assoc article :name (get article :as-preposition)))

(def ist {:name "ist" :english "is"})

(defn nouns-for-chapter [chapter]
  (into [] (filter #(and (noun? %) (chapter? % chapter)) dictionary/german)))

(nouns-for-chapter 14)
