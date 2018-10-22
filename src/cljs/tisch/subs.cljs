(ns tisch.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub ::name         (fn [db] (:name db)))
(re-frame/reg-sub ::dictionary   (fn [db] (:dictionary db)))
(re-frame/reg-sub ::current-unit (fn [db] (:current-unit db)))
(re-frame/reg-sub ::units        (fn [db] (:units db)))

;; vocab drills
(re-frame/reg-sub ::vocab-drills (fn [db] (:vocab-drills (:unit-states db))))



