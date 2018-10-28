(ns tisch.questions
  (:require [tisch.german :as german]))

(defn verb-template [subject verb tense]
  {:question [{:word subject
               :display :english
               :with-article? true}
              {:word verb
               :display :english}
              {:word tense
               :display :english}]
   :answer [{:word subject
             :display :german
             :with-article? true}
            {:word verb
             :display :german
             :tense tense
             :conjugate? true}]})

(defn random-verb-template []
  (let [verb (rand-nth (german/verbs))
        subject (rand-nth (german/basic-subjects))
        tense (rand-nth (vec german/tenses))]
    (verb-template subject verb tense)))

;; (do
;;   (defn render-phrase-word [word]

;;     word)

;;   (defn render-phrase [phrase]
;;     (into [] (map render-phrase-word phrase)))
;;   (render-phrase (:question (random-verb-template))))
