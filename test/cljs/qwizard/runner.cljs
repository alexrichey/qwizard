(ns cljs.qwizard.runner
  (:require cljs.qwizard.core-test
            [doo.runner :refer-macros [doo-tests]]))

(doo-tests 'qwizard.core-test)
