(ns qwizard.units.drills-events
  (:require [qwizard.db :as db]
            [qwizard.units.drills :as drills]
            [qwizard.utils :as utils]
            [re-frame.core :as re-frame]))

(def DB-KEY [:units :drills])

(re-frame.core/reg-event-fx
 :chapter-filter-num-change
 (fn [coeffects event]
   (let [chapter (second event)
         db      (:db coeffects)]
     (if (utils/is-actually-an-int? chapter)
       {:db (update-in db DB-KEY #(drills/set-chapter-filter % (int chapter)))}
       {}))))

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
