(ns tisch.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::things
 (fn [db]
   (:things db)))

(re-frame/reg-sub
 ::prepositions
 (fn [db]
   (:prepositions db)))
