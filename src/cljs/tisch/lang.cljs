(ns tisch.lang
  (:require
   [tisch.db :as db]
   [tisch.german :as german]
   [tisch.utils :as utils]))

(defn make-preposition-phrase []
  (let [thing1 (rand-nth (german/nouns))
        thing2 (rand-nth (german/nouns))
        prep (rand-nth (german/prepositions))]
    [(german/lookup-article (:article thing1))
     thing1
     german/ist
     prep
     (german/article->prep-article (german/lookup-article (:article thing2)))
     thing2]))
