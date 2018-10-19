(ns tisch.views
  (:require
   [re-frame.core :as re-frame]
   [tisch.subs :as subs]
   [tisch.utils :as utils]
   [tisch.lang :as lang]))

(defn article [word]
  [:span {:class (utils/article->gender word)} word]) 

(defn noun [thing]
  [:div {}
   (article (:article thing))
   (str  " " (:name thing) " -> " (:english thing))])

(defn nouns []
  (let [things (re-frame/subscribe [::subs/stuff])]
    [:div {} (map noun @things)]))


(defn prepositions []
  (let [things (re-frame/subscribe [::subs/things])
        prepositions (re-frame/subscribe [::subs/prepositions])
        phrase (-> (lang/make-preposition-phrase @prepositions @things)
                   utils/spanify-words
                   utils/insert-spaces-into-word-list)]
    [:div {} (for [word phrase]
               word)]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from der Tisch!" ]
     [:div "----------"]
     [:div {} 
      (prepositions)]
     ]))
