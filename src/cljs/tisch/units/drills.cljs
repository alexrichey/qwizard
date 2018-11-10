(ns tisch.units.drills
  (:require [tisch.german.questions :as questions]
            [tisch.german.helpers :as german]))

(defn create [name]
  {:name name
   :show-answers false
   :question-number 0 ;; note: this is not 0 indexed
   :questions []})

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

(defn next-question [unit]
  (if (< (:question-number unit)
         (count (:questions unit)))
    (update unit :question-number inc)
    (-> unit
        (update :questions conj (questions/random-basic-verb-phrase))
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
