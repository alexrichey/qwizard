(ns qwizard.german.dictionary)

(def german
  [
   ;; Chapter 17
   ;; {:german "" :article "" :plural "" :english "" :chapter 17 :type :noun}

   ;; Chapter 3
   {:german "" :article "die" :plural "-n" :english "Language" :chapter 3 :type :noun}
   {:german "Sprache" :article "die" :plural "-n" :english "Language" :chapter 3 :type :noun}
   {:german "Geschwister" :article "die" :plural true :english "Siblings" :chapter 3 :type :noun}
   {:german "Schwester" :article "die" :plural "-n" :english "Sister" :chapter 3 :type :noun}
   {:german "Bruder" :article "der" :plural "Brüder" :english "Brother" :chapter 3 :type :noun}
   {:german "Enkelin" :article "der" :plural "-nen" :english "Granddaughters" :chapter 3 :type :noun}
   {:german "Großeltern" :article "die" :plural true :english "Grandparents" :chapter 3 :type :noun}
   {:german "Großmutter" :article "die" :plural "großmütter" :english "Grandmother" :chapter 3 :type :noun}
   {:german "Opa" :article "der" :plural "-s" :english "Grandfather" :chapter 3 :type :noun}
   {:german "Großvater" :article "der" :plural "Großväter" :english "Grandfather" :chapter 3 :type :noun}
   {:german "Tochter" :article "die" :plural "Töchter" :english "Daughter" :chapter 3 :type :noun}
   {:german "Sohn" :article "der" :plural "-ë" :english "Son" :chapter 3 :type :noun}
   {:german "Eltern" :article "die" :plural true :english "Parents" :chapter 3 :type :noun}
   {:german "Mutter" :article "die" :plural "Mütter" :english "Mother" :chapter 3 :type :noun}
   {:german "Familie" :article "die" :plural "-n" :english "Family" :chapter 3 :type :noun}
   {:german "Vater" :article "der" :plural "Väter" :english "Father" :chapter 3 :type :noun}

   ;; Chapter 17
   {:german "Pflaster" :article "das" :plural "-n" :english "Patch" :chapter 17 :type :noun}
   {:german "Salbe" :article "die" :plural "-n" :english "Ointment" :chapter 17 :type :noun}
   {:german "Tablette" :article "die" :plural "-n" :english "Tablet" :chapter 17 :type :noun}
   {:german "Schmerzen" :article "die" :plural true :english "Pain" :chapter 17 :type :noun}
   {:german "Schnupfen" :article "der" :plural "-" :english "Cold (Sickness)" :chapter 17 :type :noun}
   {:german "Fieber" :article "das" :plural "-" :english "Fever" :chapter 17 :type :noun}
   {:german "Husten" :article "der" :english "Coughing Fit" :chapter 17 :type :noun}
   {:german "Praxis" :article "die" :english "Pratice (noun)" :chapter 17 :type :noun}
   {:german "Medikamente" :article "die" :plural true :english "Medication" :chapter 17 :type :noun}
   {:german "Apotheke" :article "die" :plural "-n" :english "Pharmacy" :chapter 17 :type :noun}
   {:german "Doktor" :article "der" :plural "-en" :english "Doctor" :chapter 17 :type :noun}
   {:german "Arzt" :article "der" :plural "Ärzte" :english "Doctor" :chapter 17 :type :noun}

   ;; Chapter 16
   {:german "Wasser" :article "das" :plural "-" :english "Water" :chapter 16 :type :noun}
   {:german "Dusche" :article "die" :plural "-n" :english "Shower" :chapter 16 :type :noun}
   {:german "Telefon" :article "das" :plural "-e" :english "Phone (not handy)" :chapter 16 :type :noun}
   {:german "Wecker" :article "der" :plural "-" :english "Alarm Clock" :chapter 16 :type :noun}
   {:german "Föhn" :article "der" :plural "?" :english "Hairdryer" :chapter 16 :type :noun}
   {:german "Bademantel" :article "der" :plural "der" :english "Bathrobe" :chapter 16 :type :noun}
   {:german "Handtuch" :article "das" :plural "Handtücher" :english "Hand Towel" :chapter 16 :type :noun}
   {:german "Seife" :article "die" :plural "-n" :english "Soap" :chapter 16 :type :noun}
   {:german "Licht" :article "das" :plural "-er" :english "Light" :chapter 16 :type :noun}
   {:german "Internetverbindung" :article "die" :plural "-en" :english "Internet Connection" :chapter 16 :type :noun}
   {:german "Radio" :article "das" :plural "-s" :english "Radio" :chapter 16 :type :noun}
   {:german "Fernseher" :article "der" :plural "-" :english "TV" :chapter 16 :type :noun}
   {:german "Heizung" :article "die" :plural "-en" :english "Heater" :chapter 16 :type :noun}
   {:german "Klimaanlage" :article "die" :plural "-n" :english "Air Conditioner" :chapter 16 :type :noun}
   {:german "Aufzug" :article "der" :plural "Aufzüge" :english "Elevator" :chapter 16 :type :noun}

   ;; Chapter 16 Vocab
   {:german "wichtig" :english "important"}
   {:german "" :english ""}

   ;; Chapter 16 Verbs
   {:german "Vergleichen" :english "To Compare"}
   {:german "Absagen" :english "To Cancel"}
   {:german "Verschieben" :english "To Move" :for-example "To move a meeting"}
   {:german "" :english ""}

   ;; Chapter 15 Verbs
   {:german "bedeuten" :english "to mean" :past-perfect "" :chapter 15 :type :verb}
   {:german "danken" :english "to thank" :past-perfect "gedankt" :chapter 15 :type :verb}
   {:german "fehlen" :english "to miss (missing)" :past-perfect "gefehlt" :chapter 15 :type :verb}
   {:german "gehören" :english "to belong to" :past-perfect "gehört" :chapter 15 :type :verb}
   {:german "passen" :english "to fit" :chapter 15 :type :verb}

   ;; Chapter 15 Adjectives
   {:german "wichtig" :english "important" :chapter 15 :type :adjective}
   {:german "wenige" :english "few / little" :chapter 15 :type :adjective}

   ;; Chapter 15 Vocab
   {:german "Stadtviertel" :article "das" :plural "-" :english "District" :chapter 15 :type :noun}
   {:german "Wetter" :article "das" :plural "" :english "Weather" :chapter 15 :type :noun}
   {:german "Urlaub" :article "der" :plural "" :english "Vacation" :chapter 15 :type :noun}
   {:german "Rezept" :article "das" :plural "-e" :english "Recipe" :chapter 15 :type :noun}
   {:german "Reisebüro" :article "das" :plural "s" :english "Travel Agency" :chapter 15 :type :noun}
   {:german "Mensch" :article "der" :plural "-en" :english "Human" :chapter 15 :type :noun}
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

   ;; Random
   {:german "abschied" :english "farewells" :tags #{:random}}
   {:german "begrüßen" :english "welcome (greeting words)" :tags #{:random}}
   {:german "ganz" :english "very/quite" :tags #{:random}}
   {:german "ruhe" :english "quiet" :tags #{:random}}
   {:german "dann" :english "then" :tags #{:random}}
   {:german "weitere" :english "Further" :tags #{:random}}
   {:german "wichtige" :english "Important" :type :adjective :tags #{:random}}
   {:german "selbst" :english "self" :type :pronoun :tags #{:random}}

   ;; Random Nouns
   {:german "Sätze" :article "der" :plural "-" :english "Sentence" :type :noun}
   {:german "Thema" :article "das" :plural "-n" :english "Topic" :type :noun}
   {:german "Farbe" :article "die" :plural "-n" :english "Color" :type :noun}
   {:german "Farbe" :article "die" :plural "-n" :english "Color" :type :noun}

   ;; Random Verbs
   {:german "lösen" :english "to solve"  :chapter 3 :type :verb :tags #{:random}}
   {:german "fehlen" :english "to be absent"  :type :verb :tags #{:random}}
   {:german "mischen" :english "to mix"  :type :verb :tags #{:random}}
   {:german "raten" :english "to guess"  :type :verb :tags #{:random}}

   ])
