(ns qwizard.utils)

(defn rand-str []
  (apply str (take 8 (repeatedly #(char (+ (rand 26) 65))))))

(defn is-actually-an-int? [input]
  (int? (.Number js/window input)))

(defn list->randomized-n-list [n lst]
  (let [rpt-count (/ n (count lst))]
    (into []
          (->> lst
               (repeat rpt-count)
               (map shuffle)
               flatten
               (take n)))))
