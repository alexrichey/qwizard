(ns tisch.core-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [qwizard.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
