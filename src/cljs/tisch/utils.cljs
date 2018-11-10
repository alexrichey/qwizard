(ns tisch.utils)

(defn word-list->phrase [list]
  (apply str (interpose " " list)))



(def articles #{"der" "die" "das" "den"})

(defn spanify-words [word-list]
  (map (fn [word]
         (if (contains? articles word)
           [:span {:class (article->gender word)} word]
           [:span {} word]))
       word-list))

(defn insert-spaces-into-word-list [word-list]
  (interpose " " word-list))

(defn rand-str []
  (apply str (take 8 (repeatedly #(char (+ (rand 26) 65))))))


(defn is-actually-an-int? [input]
  (int? (.Number js/window input)))
