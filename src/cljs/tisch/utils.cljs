(ns tisch.utils)

(defn rand-str []
  (apply str (take 8 (repeatedly #(char (+ (rand 26) 65))))))

(defn is-actually-an-int? [input]
  (int? (.Number js/window input)))
