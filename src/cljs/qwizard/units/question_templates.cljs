(ns qwizard.units.question-templates
  (:require [qwizard.german.helpers :as german]
            [qwizard.utils :as utils]
            [qwizard.german.phrases :as phrases]))

(defn answer-correct [question]
  (assoc question :got-it-correct true))

(defn answer-wrong [question]
  (assoc question :got-it-correct false))

(defn get-answer [question]
  (:answer question))

(defn get-question [question]
  (:question question))

(defn got-it-correct? [question]
  (:got-it-correct question))

(defn verb-template [subject verb tense]
  {:question [{:word "subject: " :raw? true} {:word subject :display :german}
              {:word " -- " :raw? true}

              {:word "verb:" :raw? true}
              {:word verb :display :english}
              {:word " -- " :raw? true}

              {:word "tense:" :raw? true}
              {:word tense :display :english}]
   :answer   [{:word subject :display :german}
              {:word verb :display :german :tense tense :conjugate? true}]})

(defn phrase-question-template [phrase]
  {:question [{:word (:english phrase) :raw? true}] :answer [{:word (:german phrase) :raw? true}]})

(defn nouns-with-article-template [noun]
  {:question [{:word "The " :raw? true}
              {:word noun :display :english}]
   :answer   [{:word (german/article-for noun) :display :german}
              {:word noun :display :german}]})


(defn generate [{question-type :question-type
                 shuffle? :shuffle?
                 total-qs :count
                 chapter-filters :chapter-filters}]
  (case question-type
    :nouns (let [query (if (some? chapter-filters)
                         [german/noun? #(german/chapter-in? % chapter-filters)]
                         [german/noun?])
                 results (german/query query)
                 ordered (if shuffle? (shuffle results) results)
                 final-nouns (take total-qs ordered)]
             (into [] (map nouns-with-article-template final-nouns)))
    :phrases (let [phrases (if shuffle? (shuffle phrases/all) phrases/all)
                   final-phrases (take total-qs phrases)]
               (into [] (map phrase-question-template phrases)))
    :verbs (let [verbs    (utils/list->randomized-n-list total-qs (german/verbs))
                 subjects (utils/list->randomized-n-list total-qs (german/basic-subjects))
                 tenses   (utils/list->randomized-n-list total-qs (german/tenses))
                 subject-verb-tense-list (map vector subjects verbs tenses)]
             (into [] (map #(apply verb-template %) subject-verb-tense-list)))
    :accusitive-nouns []))
