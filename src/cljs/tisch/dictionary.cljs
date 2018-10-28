(ns tisch.dictionary)

(def german {:things [
                      ;; Chapter 15 Verbs
                      {:name "danken" :english "to thank" :past-perfect "gedankt" :chapter 15 :type :verb}
                      {:name "fehlen" :english "to miss (missing)" :past-perfect "gefehlt" :chapter 15 :type :verb}
                      {:name "gehören" :english "to belong" :past-perfect "gehört" :chapter 15 :type :verb}
                      {:name "gehören" :english "to belong" :past-perfect "gehört" :chapter 15 :type :verb}

                      ;; Chapter 15 Adjectives
                      {:name "wichtig" :english "important" :chapter 15 :type :adjective}
                      {:name "wengi" :english "few / little" :chapter 15 :type :adjective}

                      ;; Chapter 15 Vocab
                      {:name "Wetter" :article "das" :plural "" :english "Weather" :chapter 15 :type :noun}
                      {:name "Urlaub" :article "der" :plural "" :english "Vacation" :chapter 15 :type :noun}
                      {:name "Rezept" :article "das" :plural "-e" :english "Recipe" :chapter 15 :type :noun}
                      {:name "Reisebüro" :article "das" :plural "s" :english "Travel Agency" :chapter 15 :type :noun}
                      {:name "Mesch" :article "der" :plural "-en" :english "Human" :chapter 15 :type :noun}
                      {:name "Turm" :article "der" :plural "-ë" :english "Tower" :chapter 15 :type :noun}
                      {:name "Spielplatz" :article "der" :plural "-ë" :english "Playground" :chapter 15 :type :noun}
                      {:name "Schloss" :article "das" :plural "-ër" :english "Castle" :chapter 15 :type :noun}
                      {:name "Rathaus" :article "das" :plural "-ër" :english "City Hall" :chapter 15 :type :noun}
                      {:name "Park" :article "der" :plural "-s" :english "Park" :chapter 15 :type :noun}
                      {:name "Markt" :article "der" :plural "Marktën" :english "Market" :chapter 15 :type :noun}
                      {:name "Kirche" :article "die" :plural "-en" :english "Church" :chapter 15 :type :noun}
                      {:name "Kindergarten" :article "der" :plural "Kindergärten" :english "Kindergarten" :chapter 15 :type :noun}
                      {:name "Jugendherberge" :article "die" :plural "-e" :english "Hostel" :chapter 15 :type :noun}
                      {:name "Hafen" :article "der" :plural "Häfen" :english "Port" :chapter 15 :type :noun}
                      {:name "Geschäft" :article "das" :plural "-e" :english "Business" :chapter 15 :type :noun}
                      {:name "Biblioteck" :article "die" :plural "-en" :english "Library" :chapter 15 :type :noun}


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

                      ;; Chapter 14 Verbs
                      {:name "aussehen" :english "to appear" :past-perfect "ausgesehen" :chapter 15 :type :verb}
                      {:name "bezahlen" :english "to pay" :past-perfect "bezahlt" :chapter 15 :type :verb}
                      {:name "stehen" :english "to stehen" :past-perfect "gestanden" :chapter 15 :type :verb}

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
                            {:name "hinter"   :english "behind"}]})
