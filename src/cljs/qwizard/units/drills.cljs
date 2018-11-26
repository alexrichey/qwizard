(ns qwizard.units.drills
  (:require [qwizard.german.helpers :as german]
            [qwizard.units.question-templates :as questions]))

(def UNIT-NAME "Drills Of Many Sorts!")

(def base-drill
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
   :keypress-handler nil
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

(defn current-question-path [unit]
  [:questions (- (get-current-question-num unit) 1)])

(defn get-current-question [unit]
  (get (:questions unit) (- (:question-number unit) 1)))

(defn get-questions [unit]
  (:questions unit))

(defn get-questions-on-deck [unit]
  (:questions-on-deck unit))

;; setters
(defn toggle-show-answers [unit]
  (update unit :show-answers not))

(defn back-to-first-q [unit]
  (assoc unit :question-number (if (count (:questions unit))
                                 1 0)))

(defn resupply-on-deck-if-needed [unit]
  (let [on-deck-stocked (> (count (:questions-on-deck unit)) 0)]
    (if on-deck-stocked
      unit
      (assoc unit :questions-on-deck (questions/generate {:question-type (:active-type unit)
                                                          :shuffle? true
                                                          :count 20
                                                          :chapter-filters (chapter-filters unit)})))))

(defn next-question [unit]
  (let [new-unit (-> unit
                     (assoc :show-answers false)
                     resupply-on-deck-if-needed
                     (update :question-number inc))]
    (let [at-last-question (>= (:question-number unit) (count (:questions unit)))]
      (if at-last-question
        (transfer-q-from-ondeck new-unit)
        new-unit))))

(defn previous-question [unit]
  (if (<= (:question-number unit) 1)
    unit
    (-> unit
        (update :question-number dec)
        (assoc :show-answers false))))

(defn answer-current-question [unit correct?]
  (update-in unit (current-question-path unit) (if correct? questions/answer-correct questions/answer-wrong)))

(defn reset-questions [unit]
  (-> unit
      (assoc :questions [])
      (assoc :questions-on-deck [])
      (assoc :question-number 0)))

(defn diagnostic [unit]
  (assoc unit :questions-on-deck (count (:questions-on-deck unit))))

(defn set-active-type [unit type]
  (if (not= (type (:active-type unit)))
    unit
    (-> unit
        (assoc :active-type type)
        reset-questions)))

;; handlers
(defn handle-question-answered [unit correct?]
  (-> unit
      (answer-current-question correct?)
      next-question))

(defn handle-set-filters [unit filters]
  (-> unit
      reset-questions
      (assoc :filters filters)
      next-question))

(defn handle-keypress [unit key]
  (cond
    (contains? #{:right  :L-key} key) (next-question unit)
    (contains? #{:left   :H-key} key) (previous-question unit)
    (contains? #{:up     :K-key} key) (handle-question-answered unit true)
    (contains? #{:down   :J-key} key) (handle-question-answered unit false)
    (contains? #{:enter  :tab  } key) (toggle-show-answers unit)
    (= key :zero-key) (back-to-first-q unit)
    true unit))

(defn create []
  (-> base-drill
      next-question
      (assoc :keypress-handler handle-keypress)))
