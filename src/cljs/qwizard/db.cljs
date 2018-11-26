(ns qwizard.db
  (:require [qwizard.german.dictionary :as dictionary]
            [qwizard.german.helpers :as german]
            [qwizard.units.drills :as drills]))

(def default-db
  {:name "Der Tisch"
   :current-unit :drills
   :units {:drills (drills/create)
           :quizzer {:name "Quiz Me!"}}})

(defn set-chapter-filter [db chapter]
  (if (not (some? chapter))
    db
    (let [nouns (shuffle (german/nouns-for-chapter chapter))]
      (-> db
         (assoc-in [:units :articles-drill :chapter-filter] chapter)
         (assoc-in [:units :articles-drill :vocab] nouns)
         (assoc-in [:units :articles-drill :current-word-index] 0)
         (assoc-in [:units :articles-drill :current-word] (first nouns))))))

(defn change-unit [db unit-key]
  (case unit-key
    (assoc db :current-unit unit-key)))

(defn get-unit [unit-key db]
  (first (filter #(= (:key %) unit-key) (:units db))))

(defn handle-keypress [db key]
  (let [unit-key (:current-unit db)]
    (case unit-key
      :drills (update-in db [:units :drills] #(drills/handle-keypress % key))
      db)))

(defn get-unit-names [db]
  (let [units-map (:units db)
        units-vals (map val units-map)
        names (map :name units-vals)]
    (into [] names)))
