(ns qwizard.units.question-templates
  (:require [qwizard.german.helpers :as german]
            [qwizard.german.phrases :as phrases]))

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

(defn get-answer [question]
  (:answer question))

(defn get-question [question]
  (:question question))

(defn random-basic-verb-phrase []
  (let [verb (rand-nth (german/verbs))
        subject (rand-nth (german/basic-subjects))
        tense (rand-nth (german/tenses))]
    (verb-template subject verb tense)))

(defn random-phrase-question []
  (let [phrase (rand-nth phrases/all)]
    {:question [{:word (:english phrase) :raw? true}] :answer [{:word (:german phrase) :raw? true}]}))

(defn nouns-with-article-template [noun]
  {:question [{:word "The " :raw? true}
              {:word noun :display :english}]
   :answer   [{:word (german/article-for noun) :display :german}
              {:word noun :display :german}]})

(defn random-basic-noun-question
  ([]        (nouns-with-article-template (rand-nth (german/nouns))))
  ([chapter] (nouns-with-article-template (rand-nth (german/nouns-for-chapter chapter)))))


;; {:question-type :nouns
;;  :count 20
;;  :randomize? true
;;  :chapter-filter (chapter-filter unit)}
(defn generate [params]
  (if (not= (:question-type params) :nouns)
    []
    (let [query (if (some? (:chapter-filter params))
                  [german/noun? #(german/chapter? % (:chapter-filter params))]
                  [german/noun?])
          nouns (take (:count params) (german/query query))
          final-nouns (if (:randomize? params)
                        (shuffle nouns)
                        nouns)]
      (into [] (map nouns-with-article-template final-nouns)))))
