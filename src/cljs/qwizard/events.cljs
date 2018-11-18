(ns qwizard.events
  (:require [qwizard.db :as db]
            [qwizard.units.drills-events :as drills-events]
            [qwizard.utils :as utils]
            [re-frame.core :as re-frame]))

(defn change-unit [coeffects event]
  (let [unit-key (second event)
        db      (:db coeffects)]
    {:db  (db/change-unit db unit-key)}))

(re-frame/reg-event-db      ::initialize-db (fn [_ _] db/default-db))
(re-frame.core/reg-event-fx
 :keypress
 (fn [coeffects keycode]
   (let [key-code-num (second keycode)
         codes {37 :left 39 :right 38 :up 40 :down
                72 :H-key 74 :J-key 75 :K-key 76 :L-key
                48 :zero-key}
         key (get codes key-code-num)]
     {:db (db/handle-keypress (:db coeffects) key)})))

(re-frame.core/reg-event-fx :change-unit change-unit)

