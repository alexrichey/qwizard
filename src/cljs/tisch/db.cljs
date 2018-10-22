(ns tisch.db)

(def default-db
  {:name "re-frame"
   :current-unit :preposition-phrases
   :units {:preposition-phrases {:name "Prepositional Phrases"}
           :vocab-drills        {:name "Vocab Drills!"}}
   :unit-states {}
   :dictionary {:things [
                         ;; {:name "" :article "" :plural "" :english "" :chapter 2}
                         {:name "Beruf"       :article "der" :plural "Berufe"       :english "job"       :chapter 2}
                         {:name "Ausbildung"  :article "die" :plural "Ausbildungen" :english "training"  :chapter 2}
                         {:name "Arbeitgeber" :article "der" :plural "Arbeitgeber"  :english "Employer"  :chapter 2}
                         {:name "Tisch"       :article "der" :plural "Tische"       :english "Table"     :chapter nil}
                         {:name "Handy"       :article "das" :plural "Handys"       :english "Cellphone" :chapter nil}]
                :articles [{:name "der" :as-preposition "den" :plural "die"}
                           {:name "die" :as-preposition "die" :plural "die"}
                           {:name "das" :as-preposition "die" :plural "die"}]
                :prepositions [{:name "neben"    :english "near to"}
                               {:name "auf"      :english "on top of"}
                               {:name "an"       :english "at or near"}
                               {:name "vor"      :english "in front of"}
                               {:name "zwischen" :english "in between"}
                               {:name "über"     :english "over"}
                               {:name "unter"    :english "under"}
                               {:name "in"       :english "in"}
                               {:name "hinter"   :english "behind"}]}})


(defn init-vocab-drills [db]
  (let [things (shuffle (:things (:dictionary default-db)))]
   (-> db
       (assoc :current-unit :vocab-drills)
       (assoc-in [:unit-states :vocab-drills] {:vocab things})
       (assoc-in [:unit-states :vocab-drills :current-word] "Hi there"))))

(defn change-unit [db unit-key]
  (case unit-key
    :vocab-drills (init-vocab-drills db)
    (assoc db :current-unit unit-key)))

(defn get-unit [unit-key db]
  (first (filter #(= (:key %) unit-key) (:units db))))

(let [data {:preposition-phrases {:name "Prepositional Phrases"}
            :vocab-drills        {:name "Vocab Drills!"}}]
  (into [] (map #(assoc (second %) :key (first %)) data)))

(defn units-as-list [units]
  (into [] (map #(assoc (second %) :key (first %)) units)))

(map #(into {} (assoc (second %) :key (first %))) [{:a "b"}
                                         { :c "d"}])
(first {:a :b})
(get-unit :vocab-drills default-db)

(def prepositions #{"der" "die" "das" "den"})

(defn lookup-article [dictionary article]
  (first (filter #(= (:name %) article) (:articles dictionary))))

(defn article->prep-article [article]
  (assoc article :name (get article :as-preposition)))

(def ist {:name "ist" :english "is"})
