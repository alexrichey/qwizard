(ns tisch.db)

(def default-db
  {:name "re-frame"
   :things [
            ;; {:name "" :article "" :plural "" :english "" :chapter 2}

            {:name "Beruf" :article "der" :plural "Berufe" :english "job" :chapter 2}
            {:name "Ausbildung" :article "die" :plural "Ausbildungen" :english "training" :chapter 2}
            {:name "Arbeitgeber" :article "der" :plural "Arbeitgeber" :english "Employer" :chapter 2}
            {:name "Tisch" :article "der" :plural "Tische" :english "Table" :chapter nil}
            {:name "Handy" :article "das" :plural "Handys" :english "Cellphone" :chapter nil}]
   :prepositions [{:name "neben" :english "near to"}
                  {:name "auf" :english "on top of"}
                  {:name "an" :english "at or near"}
                  {:name "vor" :english "in front of"}
                  {:name "zwischen" :english "in between"}
                  {:name "über" :english "over"}
                  {:name "unter" :english "under"}
                  {:name "in" :english "in"}
                  {:name "hinter" :english "behind"}]})
