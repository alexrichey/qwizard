(ns tisch.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [tisch.core-test]))

(doo-tests 'tisch.core-test)
