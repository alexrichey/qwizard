(ns tisch.events
  (:require
   [re-frame.core :as re-frame]
   [tisch.utils :as utils]
   [tisch.db :as db]))

(defn change-unit [coeffects event]
  (let [unit-key (second event)
        db      (:db coeffects)]
    {:db  (db/change-unit db unit-key)}))

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
(re-frame.core/reg-event-fx :chapter-filter-num-change
                            (fn [coeffects event]
                              (let [chapter (second event)]
                                (if (utils/is-actually-an-int? chapter)
                                  {:db (db/set-chapter-filter (:db coeffects) (int chapter))}
                                  {}))))
