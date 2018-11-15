(ns qwizard.units.question-templates
  (:require [qwizard.german.helpers :as german]))

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


(defn nouns-with-article-template [noun]
  {:question [{:word "The " :raw? true}
              {:word noun :display :english}]
   :answer   [{:word (german/article-for noun) :display :german}
              {:word noun :display :german}]})

(defn random-basic-noun-question
  ([]        (nouns-with-article-template (rand-nth (german/nouns))))
  ([chapter] (nouns-with-article-template (rand-nth (german/nouns-for-chapter chapter)))))
