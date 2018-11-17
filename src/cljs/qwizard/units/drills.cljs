(ns qwizard.units.drills
  (:require [qwizard.german.helpers :as german]
            [qwizard.units.question-templates :as questions]))

(defn create [name]
  {:name name
   :drill-types [{:type :verbs :name "Verbs"}
                 {:type :nouns :name "Nouns"}
                 {:type :phrases :name "Phrases"}
                 {:type :accusitive-nouns :name "Accusative Nouns"}]
   :active-type :nouns
   :show-answers false
   :chapter-filter nil
   :question-number 0 ;; note: this questions 1-indexed (ie the first question = question 1)
   :questions []})

(defn chapter-filter [unit]
  (:chapter-filter unit))

(defn get-question-for-type [unit]
  (case (:active-type unit)
    :nouns (if (some? (chapter-filter unit))
             (questions/random-basic-noun-question (chapter-filter unit))
             (questions/random-basic-noun-question))
    :verbs (questions/random-basic-verb-phrase)
    :phrases (questions/random-phrase-question)
    :accusitive-nouns (questions/random-basic-verb-phrase)))

;; getters

(defn show-answers? [unit]
  (:show-answers unit))

(defn get-total-questions [unit]
  (count (:questions unit)))

(defn get-current-question-num [unit]
  (:question-number unit))

(defn get-current-question [unit]
  (get (:questions unit) (- (:question-number unit) 1)))


;; setters
(defn toggle-show-answers [unit]
  (update unit :show-answers not))

(defn set-current-question-as-last [unit]
  (assoc unit :question-number (count (:questions unit))))

(defn reset-questions [unit]
  (-> unit
      (assoc :show-answers false)
      (assoc :questions [])
      (assoc :question-number 0)))

(defn set-active-type [unit type]
  (if (not= (type (:active-type unit)))
    unit
    (-> unit
        (assoc :active-type type)
        reset-questions)))

(defn next-question [unit]
  (if (< (:question-number unit)
         (count (:questions unit)))
    (update unit :question-number inc)
    (-> unit
        (update :questions conj (get-question-for-type unit))
        (assoc :show-answers false)
        set-current-question-as-last)))

(defn previous-question [unit]
  (if (<= (:question-number unit) 1)
    unit
    (-> unit
        (update :question-number dec)
        (assoc :show-answers false))))

(defn handle-keypress [unit key]
  (case key
    :right (next-question unit)
    :left (previous-question unit)
    :up (toggle-show-answers unit)
    :down (toggle-show-answers unit)
    unit))

(defn set-chapter-filter [unit chapter]
  (print "hi")
  (-> unit
      reset-questions
      (assoc :chapter-filter chapter)))
