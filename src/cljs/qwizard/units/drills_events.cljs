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
     (print "setting to: " type)
     {:db (update-in db DB-KEY #(drills/set-active-type % type))})))

