(ns tisch.views.language
  (:require [re-frame.core :as re-frame]
            [tisch.german.helpers :as german]
            [tisch.units.question-templates :as questions]
            [tisch.utils :as utils]))

(def SPC {:word " " :raw? true})

(defn display-template-word [template-word]
  (let [word (:word template-word)
        class (if (german/article? word)
                (german/article->gender (:german word))
                nil)]
    [:span {:key (utils/rand-str) :class class}
     (if (:raw? template-word)
       (str (:word template-word))
       (let [language (:display template-word)]
        (str (get-in template-word [:word language]))))]))

(defn phrase [template-words]
  (let [with-spaces (interpose SPC template-words)]
    [:div {:key (utils/rand-str)}
     (doall (map #(display-template-word %) with-spaces))]))
