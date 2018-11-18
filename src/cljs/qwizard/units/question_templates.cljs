(ns qwizard.units.question-templates
  (:require [qwizard.german.helpers :as german]
            [qwizard.utils :as utils]
            [qwizard.german.phrases :as phrases]))

(defn get-answer [question]
  (:answer question))

(defn get-question [question]
  (:question question))

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



;; {:question-type :nouns
;;  :count 20
;;  :shuffle? true
;;  :chapter-filter (chapter-filter unit)}
(defn generate [params]
  (case (:question-type params)
    :nouns (let [query (if (some? (:chapter-filter params))
                         [german/noun? #(german/chapter? % (:chapter-filter params))]
                         [german/noun?])
                 nouns (take (:count params) (german/query query))
                 final-nouns (if (:shuffle? params)
                               (shuffle nouns)
                               nouns)]
             (into [] (map nouns-with-article-template final-nouns)))
    :phrases (let [phrases (if (:shuffle? params) (shuffle phrases/all) phrases/all)
                   final-phrases (take (:count params) phrases)]
               (into [] (map phrase-question-template phrases)))
    :verbs (let [verbs (utils/list->randomized-n-list 20 (german/verbs))
                 subjects (utils/list->randomized-n-list 20 (german/basic-subjects))
                 tenses (utils/list->randomized-n-list 20 (german/tenses))
                 subject-verb-tense-list (map vector subjects verbs tenses)]
             (into [] (map #(apply verb-template %) subject-verb-tense-list)))))


(second (generate 
  {:question-type :verbs
   :count 20
   :shuffle? true
   :chapter-filter 15}))




