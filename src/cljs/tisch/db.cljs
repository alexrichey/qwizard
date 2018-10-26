(ns tisch.db
  (:require [tisch.dictionary :as dictionary]))

(def default-db
  {:name "re-frame"
   :current-unit :preposition-phrases
   :units {:preposition-phrases {:name "Prepositional Phrases"}
           :articles-drill      {:name "Articles drilling" :show-answers false :vocab [{:name "Initial"}]}
           :vocab-drills        {:name "Vocab Drills!"}}
   :unit-states {}
   :dictionary dictionary/german})

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
