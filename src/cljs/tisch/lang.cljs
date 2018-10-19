(ns tisch.lang
  (:require
   [tisch.utils :as utils]
   ))

(defn make-preposition-phrase [prepositions things]
  (let [thing (rand-nth things)
        other-thing (rand-nth things)
        prep (rand-nth prepositions)]
    [(:article thing) (:name thing)
     "ist" (:name prep)
     (utils/singular-article->prep-article (:article other-thing)) (:name other-thing)]))
