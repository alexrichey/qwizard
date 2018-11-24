(ns cljs.qwizard.core-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [qwizard.core :as core]
            [qwizard.db :as db]
            [qwizard.units.drills :as drills]))

(def db (-> db/default-db))

(deftest db-test
  (testing "Unit Names"
    (is (= [drills/UNIT-NAME]
           (db/get-unit-names db)))))

(db-test)
