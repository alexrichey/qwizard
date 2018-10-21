(ns tisch.utils)

(defn article->gender [article]
  (case (str article)
    "der" "masc"
    "den" "masc"
    "die" "fem"
    "das" "neutral"))

(defn word-list->phrase [list]
  (apply str (interpose " " list)))

(defn singular-article->prep-article [article]
  (case (str article)
    "der" "den"
    "die" "die"
    "das" "das"))

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
