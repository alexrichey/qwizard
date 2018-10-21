(ns tisch.lang
  (:require
   [tisch.db :as db]
   [tisch.utils :as utils]
   [com.rpl.specter :as s]))

(defn make-preposition-phrase [dictionary]
  (let [thing1 (rand-nth (:things dictionary))
        thing2 (rand-nth (:things dictionary))
        prep (rand-nth (:prepositions dictionary))]
    [(db/lookup-article dictionary (:article thing1))
     thing1
     db/ist
     prep
     (db/article->prep-article (db/lookup-article dictionary (:article thing2)))
     thing2]))
