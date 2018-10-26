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

(defn toggle-show-answers [coeffects event]
  (let [db (:db coeffects)]
    {:db (db/toggle-show-answers db)}))

(re-frame/reg-event-db      ::initialize-db (fn [_ _] db/default-db))

(re-frame.core/reg-event-fx :keypress (fn [coeffects keycode]
                                        (let [key-code-num (second keycode)
                                              codes {37 :left
                                                     39 :right
                                                     38 :up
                                                     40 :down}
                                              key (get codes key-code-num)]
                                          {:db (db/handle-keypress (:db coeffects) key)})))

(re-frame.core/reg-event-fx :change-unit change-unit)
(re-frame.core/reg-event-fx :init-vocab-drills init-vocab-drills)
(re-frame.core/reg-event-fx :toggle-show-answers toggle-show-answers)

(re-frame.core/reg-event-fx :next-question (fn [coeffects event] {:db (db/articles-drill-next-question (:db coeffects))}))
(re-frame.core/reg-event-fx :previous-question (fn [coeffects event] {:db (db/articles-drill-previous-question (:db coeffects))}))
