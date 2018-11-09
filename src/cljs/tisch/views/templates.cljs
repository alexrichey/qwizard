(ns tisch.views.templates
  (:require
   [re-frame.core :as re-frame]
   [tisch.german :as german]
   [tisch.views.language :as lang]
   [tisch.questions :as questions]))

(defn random-phrase [show-answer?]
  (let [question (questions/random-basic-verb-phrase)
        noun-q (questions/random-basic-noun-question)]
    [:div {}
     (if show-answer?
       (lang/phrase (:question noun-q) :english)
       (lang/phrase (:answer noun-q) :german))]))
