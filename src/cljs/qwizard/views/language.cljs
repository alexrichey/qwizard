(ns qwizard.views.language
  (:require [qwizard.german.helpers :as german]
            [qwizard.units.question-templates :as questions]
            [qwizard.utils :as utils]
            [re-frame.core :as re-frame]))

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
