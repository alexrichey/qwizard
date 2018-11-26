(ns qwizard.views.diagnostic
  (:require [soda-ash.core :as sa]
            [qwizard.utils :as utils]))

(defn viewer []
  (fn [m]
    [sa/Table {:celled true}
     [sa/TableHeader
      [sa/TableRow
       [sa/TableHeaderCell "Key"]
       [sa/TableHeaderCell "Val"]]]
     [sa/TableBody 
      (map (fn [kv] [sa/TableRow {:key (utils/rand-str)}
                     [sa/TableCell {:key (utils/rand-str)} (str (key kv))]
                     [sa/TableCell {:key (utils/rand-str)} (str (val kv))]])
           m)]]))
