(ns tisch.lang
  (:require
   [tisch.db :as db]
   [tisch.german :as german]
   [tisch.utils :as utils]))

(defn make-preposition-phrase [dictionary]
  (let [thing1 (rand-nth (:things dictionary))
        thing2 (rand-nth (:things dictionary))
        prep (rand-nth (:prepositions dictionary))]
    [(german/lookup-article (:article thing1))
     thing1
     german/ist
     prep
     (german/article->prep-article (german/lookup-article (:article thing2)))
     thing2]))
