(ns qwizard.german.helpers
  (:require [qwizard.german.dictionary :as dictionary]
            [clojure.set :as set]))

;; dictionary filters
(defn article? [word]
  (= (:type word) :article))

(defn noun? [word]
  (= (:type word) :noun))

(defn preposition? [word]
  (= (:type word) :preposition))

(defn verb? [word chapter]
  (= (:type word) :verb))

(defn tense? [word chapter]
  (= (:type word) :tense))

;; ie, "I", "You", "We"
(defn basic-subject? [word chapter]
  (:basic-subject? word))

(defn chapter? [word chapter]
  (= (:chapter word) chapter))

(defn query [filters]
  (loop [filters filters
         words dictionary/german]
    (if (and (> (count words) 0)
             (> (count filters) 0))
      (recur (rest filters) (filter (first filters) words))
      words)))


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

(defn words-for-chapter [chapter]
  (into [] (filter #(chapter? % chapter)) dictionary/german))

(defn tenses []
  (into [] (filter tense? dictionary/german)))

;; helpers
(defn lookup-article [article]
  (first (filter #(= (:german %) article) (articles))))

(defn article-for [noun]
  (lookup-article (:article noun)))

(defn article->prep-article [article]
  (assoc article :german (get article :as-preposition)))


(def ist {:german "ist" :english "is"})

(defn nouns-for-chapter [chapter]
  (into [] (filter #(and (noun? %) (chapter? % chapter)) dictionary/german)))

(defn article->gender [article]
  (case (str article)
    "der" "masc"
    "den" "masc"
    "die" "fem"
    "das" "neutral"
    nil))

(defn singular-article->prep-article [article]
  (case (str article)
    "der" "den"
    "die" "die"
    "das" "das"
    ""))
