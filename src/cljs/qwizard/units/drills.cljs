(ns qwizard.units.drills
  (:require [qwizard.german.helpers :as german]
            [qwizard.units.question-templates :as questions]))

(def UNIT-NAME "Drills Of Many Sorts!")

(defn create []
  {:name UNIT-NAME
   :drill-types [{:type :verbs :name "Verbs"}
                 {:type :nouns :name "Nouns"}
                 {:type :phrases :name "Phrases"}
                 {:type :accusitive-nouns :name "Accusative Nouns"}]
   :active-type :nouns
   :filters {}
   :show-answers false
   :question-number 0 ;; note: question-number is 1-indexed (ie the first question is question 1)
   :questions-on-deck []
   :questions []})

(defn chapter-filters [unit]
  (get-in unit [:filters :selected-chapters]))

(defn transfer-q-from-ondeck [unit]
  (if (not (> (count (:questions-on-deck unit)) 0))
    unit
    (-> unit
        (update :questions #(conj % (last (:questions-on-deck unit))))
        (update :questions-on-deck pop))))

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

(defn back-to-first-q [unit]
  (assoc unit :question-number (if (count (:questions unit))
                                 1 0)))

(defn reset-questions [unit]
  (-> unit
      (assoc :show-answers false)
      (assoc :questions [])
      (assoc :questions-on-deck [])
      (assoc :question-number 0)))

(defn set-filters [unit filters]
  (-> unit
      reset-questions
      (assoc :filters filters)))

(defn set-active-type [unit type]
  (if (not= (type (:active-type unit)))
    unit
    (-> unit
        (assoc :active-type type)
        reset-questions)))

(defn set-next-question [unit]
  (if (> (count (:questions-on-deck unit)) 0)
    (transfer-q-from-ondeck unit)
    (-> unit
        (assoc :questions-on-deck (questions/generate {:question-type (:active-type unit)
                                                       :shuffle? true
                                                       :count 20
                                                       :chapter-filters (chapter-filters unit)}))
        (transfer-q-from-ondeck))))

(defn next-question [unit]
  (if (< (:question-number unit)
         (count (:questions unit)))
    (update unit :question-number inc)
    (-> unit
        (set-next-question)
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
    :L-key (next-question unit)
    :left (previous-question unit)
    :H-key (previous-question unit)
    :up (toggle-show-answers unit)
    :K-key (toggle-show-answers unit)
    :down (toggle-show-answers unit)
    :J-key (toggle-show-answers unit)
    :zero-key (back-to-first-q unit)
    unit))
