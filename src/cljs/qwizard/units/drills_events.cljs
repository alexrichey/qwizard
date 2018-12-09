(ns qwizard.units.drills-events
  (:require [qwizard.db :as db]
            [qwizard.units.drills :as drills]
            [qwizard.utils :as utils]
            [re-frame.core :as re-frame]))

(def DB-KEY [:units :drills])

(re-frame.core/reg-event-fx
 :form-change
 (fn [coeffects event]
   (let [filters (second event)
         db    (:db coeffects)]
     {:db (update-in db DB-KEY #(drills/handle-set-filters % filters))})))

(re-frame.core/reg-event-fx
 :set-drill-type
 (fn [coeffects event]
   (let [type (second event)
         db   (:db coeffects)]
     {:db (update-in db DB-KEY #(drills/set-active-type % type))})))

(re-frame.core/reg-event-fx
 :toggle-show-answers
 (fn [coeffects event]
   (let [db (:db coeffects)]
     {:db (update-in db DB-KEY #(drills/toggle-show-answers %))})))

(re-frame.core/reg-event-fx
 :change-question
 (fn [coeffects event]
   (let [db (:db coeffects)
         direction (second event)]
     (case direction
       :next {:db (update-in db DB-KEY #(drills/next-question %))}
       :previous {:db (update-in db DB-KEY #(drills/previous-question %))}))))

(re-frame.core/reg-event-fx
 :answer-question
 (fn [coeffects event]
   (let [db (:db coeffects)
         correct? (second event)]
     {:db (update-in db DB-KEY #(drills/handle-question-answered % correct?))})))

(re-frame.core/reg-event-fx
 :disable-control-modal-auto-open
 (fn [coeffects event]
   (let [db (:db coeffects)
         correct? (second event)]
     {:db (update-in db DB-KEY drills/turn-off-show-controls-on-init)})))
