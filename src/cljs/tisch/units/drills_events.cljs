(ns tisch.units.drills-events
  (:require
   [re-frame.core :as re-frame]
   [tisch.utils :as utils]
   [tisch.units.drills :as drills]
   [tisch.db :as db]))

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
     (print "setting to: " type)
     {:db (update-in db DB-KEY #(drills/set-active-type % type))})))

