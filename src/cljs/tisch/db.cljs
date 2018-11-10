(ns tisch.db
  (:require [tisch.dictionary :as dictionary]
            [tisch.units.drills :as drills]
            [tisch.german :as german]))

(def default-db
  {:name "Der Tisch"
   :current-unit :drills
   :units {:drills (drills/create "Drills of Many Sorts!")}
   :unit-states {}})

(defn init-vocab-drills [db]
  (let [nouns (shuffle (german/nouns))]
    (-> db
        (assoc :current-unit :vocab-drills)
        (assoc-in [:unit-states :vocab-drills] {:vocab nouns})
        (assoc-in [:unit-states :vocab-drills :current-word] "Hi there"))))

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
    :vocab-drills (init-vocab-drills db)
    (assoc db :current-unit unit-key)))

(defn get-unit [unit-key db]
  (first (filter #(= (:key %) unit-key) (:units db))))

(defn units-as-list [units]
  (into [] (map #(assoc (second %) :key (first %)) units)))

(defn handle-keypress [db key]
  (let [unit-key (:current-unit db)]
    (case unit-key
      :drills (update-in db [:units :drills] #(drills/handle-keypress % key))
      db)))
