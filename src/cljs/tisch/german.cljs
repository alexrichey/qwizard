(ns tisch.german
  (:require [tisch.dictionary :as dictionary]))

;; filters
(defn article? [word]
  (= (:type word) :article))

(defn noun? [word]
  (= (:type word) :noun))

(defn preposition? [word]
  (= (:type word) :preposition))

(defn verb? [word chapter]
  (= (:type word) :verb))

;; ie, "I", "You", "We"
(defn basic-subject? [word chapter]
  (:basic-subject? word))

(defn chapter? [word chapter]
  (= (:chapter word) chapter))

;; getters
(defn articles []
  (into [] (filter article? dictionary/german)))

(defn verbs []
  (into [] (filter verb? dictionary/german)))

(defn nouns []
  (into [] (filter noun? dictionary/german)))

(defn prepositions []
  (into [] (filter preposition? dictionary/german)))

(defn basic-subjects []
  (into [] (filter basic-subject? dictionary/german)))
( basic-subjects)
(defn words-for-chapter [chapter]
  (into [] (filter #(chapter? % chapter)) dictionary/german))

;; helpers
(defn lookup-article [article]
  (first (filter #(= (:german %) article) (articles))))

(defn article->prep-article [article]
  (assoc article :german (get article :as-preposition)))

(def tenses #{:present :past-perfect})
(def ist {:german "ist" :english "is"})

(defn nouns-for-chapter [chapter]
  (into [] (filter #(and (noun? %) (chapter? % chapter)) dictionary/german)))
