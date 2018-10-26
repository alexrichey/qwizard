(ns tisch.db)

(def default-db
  {:name "re-frame"
   :current-unit :preposition-phrases
   :units {:preposition-phrases {:name "Prepositional Phrases"}
           :articles-drill      {:name "Articles drilling" :show-answers false :vocab [{:name "Initial"}]}
           :vocab-drills        {:name "Vocab Drills!"}}
   :unit-states {}
   :dictionary {:things [
                         ;; Chapter 14 Vocab
                         {:name "Haus" :article "das" :plural "Häuser" :english "House" :chapter 14 :type :noun}
                         {:name "Wohnung" :article "die" :plural "-en" :english "Apartment" :chapter 14 :type :noun}
                         {:name "Balkon" :article "der" :plural "-e" :english "Balcony" :chapter 14 :type :noun}
                         {:name "Baum" :article "der" :plural "-ë" :english "Tree" :chapter 14 :type :noun}
                         {:name "Blume" :article "die" :plural "-n" :english "Flower" :chapter 14 :type :noun}
                         {:name "Erdgeschoss" :article "das" :plural "-e" :english "Ground Floor" :chapter 14 :type :noun}
                         {:name "Fenster" :article "das" :plural "-" :english "Window" :chapter 14 :type :noun}
                         {:name "Garage" :article "die" :plural "n" :english "Garage" :chapter 14 :type :noun}
                         {:name "Garten" :article "der" :plural "-n" :english "Garden" :chapter 14 :type :noun}
                         {:name "Keller" :article "der" :plural "-" :english "Basement" :english-alt "Celler" :chapter 14 :type :noun}
                         {:name "Licht" :article "das" :plural "-er" :english "Light" :chapter 14 :type :noun}
                         {:name "Miete" :article "die" :plural "-n" :english "Rental Fee" :chapter 14 :type :noun}
                         {:name "Müll" :article "der" :plural "" :english "Rubbish" :chapter 14 :type :noun}
                         {:name "Nachbar" :article "der" :plural "-n" :english "Neighboring" :chapter 14 :type :noun}
                         {:name "Nachbarin" :article "der" :plural "-nen" :english "Neighbor" :chapter 14 :type :noun}
                         {:name "Quadratmeter" :article "der" :plural "" :english "square meters" :chapter 14 :type :noun :notes "pronounced Kwa drot mit ta"}
                         {:name "Stock" :article "der" :plural "Stockwerke" :english "Floor" :chapter 14 :type :noun}
                         {:name "Treppe" :article "die" :plural "-n" :english "Stairway" :chapter 14 :type :noun}
                         {:name "Vermieter" :article "der" :plural "-n" :english "Landlord" :chapter 14 :type :noun}
                         {:name "Wasser" :article "das" :plural "-" :english "Water" :chapter 14 :type :noun}
                         {:name "gemütlich" :english "cozy" :type :adjective :chapter 14}
                         {:name "Arbeitszimmer" :article "das" :plural "" :english "study (room)" :chapter 14 :type :noun}
                         {:name "Zimmer" :article "das" :plural "-" :english "Room" :chapter 14 :type :noun}
                         {:name "Bad" :article "das" :plural "-ër" :english "Bathroom" :chapter 14 :type :noun}
                         {:name "Flur" :article "der" :plural "-e" :english "Corridor" :english-alts ["Hallway"] :chapter 14 :type :noun}
                         {:name "Kinderzimmer" :article "das" :plural "" :english "Nursery" :chapter 14 :type :noun}
                         {:name "Küche" :article "die" :plural "-n" :english "Kitchen" :chapter 14 :type :noun}
                         {:name "Schlafzimmer" :article "das" :plural "-" :english "Bedroom" :chapter 14 :type :noun}
                         {:name "Toilette" :article "die" :plural "-n" :english "Toilet (Room)" :chapter 14 :type :noun}
                         {:name "Wohnzimmer" :article "das" :plural "-" :english "Living Room" :chapter 14 :type :noun}
                         {:name "Berg" :article "der" :plural "-e" :english "Mountain" :chapter 14 :type :noun}
                         {:name "Fluss" :article "der" :plural "-ë" :english "River" :chapter 14 :type :noun}
                         {:name "Meer" :article "das" :plural "-e" :english "Sea" :chapter 14 :type :noun}
                         {:name "Wald" :article "der" :plural "-ër" :english "Forest" :chapter 14 :type :noun}
                         {:name "Anzeige" :article "die" :plural "-n" :english "Display" :chapter 14 :type :noun}
                         {:name "Fabrik" :article "die" :plural "-en" :english "Factory" :chapter 14 :type :noun}
                         {:name "Familie" :article "die" :plural "-n" :english "Family" :chapter 14 :type :noun}
                         {:name "Stadt" :article "die" :plural "-ë" :english "City" :chapter 14 :type :noun}
                         {:name "Zelt" :article "das" :plural "-e" :english "Tent" :chapter 14 :type :noun}
                         ;; {:name "" :article "das" :plural "-e" :english "Tent" :chapter 14 :type :noun}

                         ;; Chapter 14 Prepositional Adjectives
                         {:name "hinten" :english "behind" :chapter 14}
                         {:name "oben" :english "above" :chapter 14}
                         {:name "unten" :english "below" :chapter 14}
                         {:name "vorn" :english "front" :chapter 14}

                         ;; Random
                         {:name "weitere" :english "Further" }
                         {:name "wichtige" :english "Important" :type :adjective}

                         ;; previous Chapters
                         {:name "Wortschatz"  :article "der" :plural "Wortschätze"  :english "Vocabulary" :chapter 14 :type :noun}
                         {:name "Beruf"       :article "der" :plural "Berufe"       :english "job"       :chapter 2 :type :noun}
                         {:name "Bildung"     :article "die" :plural "Bildungen"    :english "Education" :type :noun}
                         {:name "Ausbildung"  :article "die" :plural "Ausbildungen" :english "training"  :chapter 2 :type :noun}
                         {:name "Arbeitgeber" :article "der" :plural "Arbeitgeber"  :english "Employer"  :chapter 2 :type :noun}
                         {:name "Tisch"       :article "der" :plural "Tische"       :english "Table"     :chapter nil :type :noun}
                         {:name "Handy"       :article "das" :plural "Handys"       :english "Cellphone" :chapter nil :type :noun}]
                :articles [{:name "der" :as-preposition "den" :plural "die" :akkusative-dein "deinen"}
                           {:name "die" :as-preposition "die" :plural "die" :akkusative-dein "deine"}
                           {:name "das" :as-preposition "die" :plural "die" :akkusative-dein "dein"}]
                :prepositions [{:name "neben"    :english "near to"}
                               {:name "auf"      :english "on top of"}
                               {:name "an"       :english "at or near"}
                               {:name "vor"      :english "in front of"}
                               {:name "zwischen" :english "in between"}
                               {:name "über"     :english "over"}
                               {:name "unter"    :english "under"}
                               {:name "in"       :english "in"}
                               {:name "hinter"   :english "behind"}]}})

(defn nouns [dictionary]
  (into [] (filter #(= (:type %) :noun) (:things dictionary))))

(defn init-vocab-drills [db]
  (let [things (shuffle (:things (:dictionary default-db)))]
    (-> db
        (assoc :current-unit :vocab-drills)
        (assoc-in [:unit-states :vocab-drills] {:vocab things})
        (assoc-in [:unit-states :vocab-drills :current-word] "Hi there"))))

(defn init-articles-drill [db]
  (let [nouns (shuffle (nouns (:dictionary db)))]
    (-> db
       (assoc :current-unit :articles-drill)
       (assoc-in [:units :articles-drill :vocab] nouns)
       (assoc-in [:units :articles-drill :current-word-index] 0)
       (assoc-in [:units :articles-drill :current-word] (first nouns)))))

(defn change-unit [db unit-key]
  (case unit-key
    :vocab-drills (init-vocab-drills db)
    :articles-drill (init-articles-drill db)
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

(def prepositions #{"der" "die" "das" "den"})

(defn lookup-article [dictionary article]
  (first (filter #(= (:name %) article) (:articles dictionary))))

(defn article->prep-article [article]
  (assoc article :name (get article :as-preposition)))

(def ist {:name "ist" :english "is"})

(defn toggle-show-answers [db]
  (update-in db [:units :articles-drill :show-answers] not))

(defn articles-drill-next-question [db]
  (let [vocab                      (:vocab (:articles-drill (:units db)))
        current-index (:current-word-index (:articles-drill (:units db)))
        next-index (mod (inc current-index) (count vocab))
        shuffle-words? (= next-index 0)]
    (-> db
        (assoc-in [:units :articles-drill :current-word-index] next-index)
        (update-in [:units :articles-drill :vocab] (if shuffle-words? shuffle identity)))))


(defn articles-drill-previous-question [db]
  (let [vocab                      (:vocab (:articles-drill (:units db)))
        current-index (:current-word-index (:articles-drill (:units db)))
        prev-index (mod (dec current-index) (count vocab))]
    (-> db
        (assoc-in [:units :articles-drill :current-word-index] prev-index))))

(defn handle-keypress [db key]
  (let [unit-key (:current-unit db)]
   (case unit-key
     :articles-drill (case key
                       :right (articles-drill-next-question db)
                       :left (articles-drill-previous-question db)
                       :up (toggle-show-answers db)
                       :down (toggle-show-answers db)
                       db)
     db)))
