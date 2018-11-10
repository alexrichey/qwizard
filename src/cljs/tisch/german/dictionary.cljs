(ns tisch.german.dictionary)

(def german
  [
   ;; Chapter 15 Verbs
   {:german "danken" :english "to thank" :past-perfect "gedankt" :chapter 15 :type :verb}
   {:german "fehlen" :english "to miss (missing)" :past-perfect "gefehlt" :chapter 15 :type :verb}
   {:german "gehören" :english "to belong to" :past-perfect "gehört" :chapter 15 :type :verb}

   ;; Chapter 15 Adjectives
   {:german "wichtig" :english "important" :chapter 15 :type :adjective}
   {:german "wengi" :english "few / little" :chapter 15 :type :adjective}

   ;; Chapter 15 Vocab
   {:german "Wetter" :article "das" :plural "" :english "Weather" :chapter 15 :type :noun}
   {:german "Urlaub" :article "der" :plural "" :english "Vacation" :chapter 15 :type :noun}
   {:german "Rezept" :article "das" :plural "-e" :english "Recipe" :chapter 15 :type :noun}
   {:german "Reisebüro" :article "das" :plural "s" :english "Travel Agency" :chapter 15 :type :noun}
   {:german "Mesch" :article "der" :plural "-en" :english "Human" :chapter 15 :type :noun}
   {:german "Turm" :article "der" :plural "-ë" :english "Tower" :chapter 15 :type :noun}
   {:german "Spielplatz" :article "der" :plural "-ë" :english "Playground" :chapter 15 :type :noun}
   {:german "Schloss" :article "das" :plural "-ër" :english "Castle" :chapter 15 :type :noun}
   {:german "Rathaus" :article "das" :plural "-ër" :english "City Hall" :chapter 15 :type :noun}
   {:german "Park" :article "der" :plural "-s" :english "Park" :chapter 15 :type :noun}
   {:german "Markt" :article "der" :plural "Marktën" :english "Market" :chapter 15 :type :noun}
   {:german "Kirche" :article "die" :plural "-en" :english "Church" :chapter 15 :type :noun}
   {:german "Kindergarten" :article "der" :plural "Kindergärten" :english "Kindergarten" :chapter 15 :type :noun}
   {:german "Jugendherberge" :article "die" :plural "-e" :english "Hostel" :chapter 15 :type :noun}
   {:german "Hafen" :article "der" :plural "Häfen" :english "Port" :chapter 15 :type :noun}
   {:german "Geschäft" :article "das" :plural "-e" :english "Business" :chapter 15 :type :noun}
   {:german "Biblioteck" :article "die" :plural "-en" :english "Library" :chapter 15 :type :noun}


   ;; Chapter 14 Vocab
   {:german "Haus" :article "das" :plural "Häuser" :english "House" :chapter 14 :type :noun}
   {:german "Wohnung" :article "die" :plural "-en" :english "Apartment" :chapter 14 :type :noun}
   {:german "Balkon" :article "der" :plural "-e" :english "Balcony" :chapter 14 :type :noun}
   {:german "Baum" :article "der" :plural "-ë" :english "Tree" :chapter 14 :type :noun}
   {:german "Blume" :article "die" :plural "-n" :english "Flower" :chapter 14 :type :noun}
   {:german "Erdgeschoss" :article "das" :plural "-e" :english "Ground Floor" :chapter 14 :type :noun}
   {:german "Fenster" :article "das" :plural "-" :english "Window" :chapter 14 :type :noun}
   {:german "Garage" :article "die" :plural "n" :english "Garage" :chapter 14 :type :noun}
   {:german "Garten" :article "der" :plural "-n" :english "Garden" :chapter 14 :type :noun}
   {:german "Keller" :article "der" :plural "-" :english "Basement" :english-alt "Celler" :chapter 14 :type :noun}
   {:german "Licht" :article "das" :plural "-er" :english "Light" :chapter 14 :type :noun}
   {:german "Miete" :article "die" :plural "-n" :english "Rental Fee" :chapter 14 :type :noun}
   {:german "Müll" :article "der" :plural "" :english "Rubbish" :chapter 14 :type :noun}
   {:german "Nachbar" :article "der" :plural "-n" :english "Neighboring" :chapter 14 :type :noun}
   {:german "Nachbarin" :article "der" :plural "-nen" :english "Neighbor" :chapter 14 :type :noun}
   {:german "Quadratmeter" :article "der" :plural "" :english "square meters" :chapter 14 :type :noun :notes "pronounced Kwa drot mit ta"}
   {:german "Stock" :article "der" :plural "Stockwerke" :english "Floor" :chapter 14 :type :noun}
   {:german "Treppe" :article "die" :plural "-n" :english "Stairway" :chapter 14 :type :noun}
   {:german "Vermieter" :article "der" :plural "-n" :english "Landlord" :chapter 14 :type :noun}
   {:german "Wasser" :article "das" :plural "-" :english "Water" :chapter 14 :type :noun}
   {:german "gemütlich" :english "cozy" :type :adjective :chapter 14}
   {:german "Arbeitszimmer" :article "das" :plural "" :english "study (room)" :chapter 14 :type :noun}
   {:german "Zimmer" :article "das" :plural "-" :english "Room" :chapter 14 :type :noun}
   {:german "Bad" :article "das" :plural "-ër" :english "Bathroom" :chapter 14 :type :noun}
   {:german "Flur" :article "der" :plural "-e" :english "Corridor" :english-alts ["Hallway"] :chapter 14 :type :noun}
   {:german "Kinderzimmer" :article "das" :plural "" :english "Nursery" :chapter 14 :type :noun}
   {:german "Küche" :article "die" :plural "-n" :english "Kitchen" :chapter 14 :type :noun}
   {:german "Schlafzimmer" :article "das" :plural "-" :english "Bedroom" :chapter 14 :type :noun}
   {:german "Toilette" :article "die" :plural "-n" :english "Toilet (Room)" :chapter 14 :type :noun}
   {:german "Wohnzimmer" :article "das" :plural "-" :english "Living Room" :chapter 14 :type :noun}
   {:german "Berg" :article "der" :plural "-e" :english "Mountain" :chapter 14 :type :noun}
   {:german "Fluss" :article "der" :plural "-ë" :english "River" :chapter 14 :type :noun}
   {:german "Meer" :article "das" :plural "-e" :english "Sea" :chapter 14 :type :noun}
   {:german "Wald" :article "der" :plural "-ër" :english "Forest" :chapter 14 :type :noun}
   {:german "Anzeige" :article "die" :plural "-n" :english "Display" :chapter 14 :type :noun}
   {:german "Fabrik" :article "die" :plural "-en" :english "Factory" :chapter 14 :type :noun}
   {:german "Familie" :article "die" :plural "-n" :english "Family" :chapter 14 :type :noun}
   {:german "Stadt" :article "die" :plural "-ë" :english "City" :chapter 14 :type :noun}
   {:german "Zelt" :article "das" :plural "-e" :english "Tent" :chapter 14 :type :noun}
   ;; {:german "" :article "das" :plural "-e" :english "Tent" :chapter 14 :type :noun}

   ;; Chapter 14 Verbs
   {:german "aussehen" :english "to appear" :past-perfect "ausgesehen" :chapter 15 :type :verb}
   {:german "bezahlen" :english "to pay" :past-perfect "bezahlt" :chapter 15 :type :verb}
   {:german "stehen" :english "to stehen" :past-perfect "gestanden" :chapter 15 :type :verb}

   ;; Chapter 14 Prepositional Adjectives
   {:german "hinten" :english "behind" :chapter 14}
   {:german "oben" :english "above" :chapter 14}
   {:german "unten" :english "below" :chapter 14}
   {:german "vorn" :english "front" :chapter 14}

   ;; Random
   {:german "weitere" :english "Further" }
   {:german "wichtige" :english "Important" :type :adjective}

   ;; previous Chapters
   {:german "Wortschatz"  :article "der" :plural "Wortschätze"  :english "Vocabulary" :chapter 14 :type :noun}
   {:german "Beruf"       :article "der" :plural "Berufe"       :english "job"       :chapter 2 :type :noun}
   {:german "Bildung"     :article "die" :plural "Bildungen"    :english "Education" :type :noun}
   {:german "Ausbildung"  :article "die" :plural "Ausbildungen" :english "training"  :chapter 2 :type :noun}
   {:german "Arbeitgeber" :article "der" :plural "Arbeitgeber"  :english "Employer"  :chapter 2 :type :noun}
   {:german "Tisch"       :article "der" :plural "Tische"       :english "Table"     :chapter nil :type :noun}
   {:german "Handy"       :article "das" :plural "Handys"       :english "Cellphone" :chapter nil :type :noun}

   ;; articles
   {:german "der" :as-preposition "den" :plural "die" :akkusative-dein "deinen" :type :article}
   {:german "die" :as-preposition "die" :plural "die" :akkusative-dein "deine" :type :article}
   {:german "das" :as-preposition "die" :plural "die" :akkusative-dein "dein" :type :article}

   ;; basic subject
   {:german "Ich" :english "I" :type :noun :basic-subject? true}
   {:german "Du" :english "You" :type :noun :basic-subject? true}
   {:german "Wir" :english "We" :type :noun :basic-subject? true}
   {:german "Ihr" :english "You All" :type :noun :basic-subject? true}
   {:german "er" :english "He" :type :noun :basic-subject? true}
   {:german "sie" :english "She" :type :noun :basic-subject? true}
   {:german "sie" :english "She" :type :noun :basic-subject? true}

   ;; tenses
   {:german "prasent" :english "present" :type :tense}
   {:german "perfekt" :english "perfect" :type :tense}
   {:german "past?"   :english "past"    :type :tense}

   ;; prepositions
   {:german "neben"    :english "near to" :type :preposition}
   {:german "auf"      :english "on top of" :type :preposition}
   {:german "an"       :english "at or near" :type :preposition}
   {:german "vor"      :english "in front of" :type :preposition}
   {:german "zwischen" :english "in between" :type :preposition}
   {:german "über"     :english "over" :type :preposition}
   {:german "unter"    :english "under" :type :preposition}
   {:german "in"       :english "in" :type :preposition}
   {:german "hinter"   :english "behind" :type :preposition}
   {:german "hinter"   :english "behind" :type :preposition}

   ])
