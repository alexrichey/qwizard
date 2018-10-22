(ns tisch.events
  (:require
   [re-frame.core :as re-frame]
   [tisch.db :as db]))

(defn change-unit [coeffects event]
  (let [unit-key (second event)
        db      (:db coeffects)]
    {:db  (db/change-unit db unit-key)}))

(defn init-vocab-drills [coeffects event]
  (let [db (:db coeffects)]
    {:db (db/init-vocab-drills db)}))

(re-frame/reg-event-db      ::initialize-db (fn [_ _] db/default-db))

(re-frame.core/reg-event-fx :change-unit change-unit)
(re-frame.core/reg-event-fx :init-vocab-drills init-vocab-drills)
