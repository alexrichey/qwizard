(ns qwizard.db
  (:require [qwizard.german.dictionary :as dictionary]
            [qwizard.german.helpers :as german]
            [qwizard.units.drills :as drills]))

(def default-db
  {:name "Qwizard DB"
   :current-unit :drills
   :units {:drills (drills/create)
           :quizzer {:key :quizzer :name "More Types Soon!"}}})

(defn change-unit [db unit-key]
  (case unit-key
    (assoc db :current-unit unit-key)))

(defn get-unit [unit-key db]
  (first (filter #(= (:key %) unit-key) (:units db))))

(defn handle-keypress [db key]
  "Routes the keypress to the handler for the active unit"
  (let [unit-key (:current-unit db)
        keypress-handler (get-in db [:units unit-key :keypress-handler])]
    (update-in db [:units unit-key] #(keypress-handler % key))))
