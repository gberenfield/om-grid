(ns om-grid.utils)

(defn olog [& objects]
  (doseq [o objects]
    (.log js/console (clj->js o))))

(def first-names ["Bob" "Robert" "Carl" "Ed" "Derrick" "Jim" "Tom" "Dennis" "Mike" "Zack"])
(def last-names ["Williams" "Jones" "Smith" "Evans" "Donovan" "Lambert" "Ashton" "Kline" "Morrison" "Barns"])

(def street ["Elm" "Oak" "Ashburn" "Winding" "Pine" "Main" "Padderson" "Maple" "Cedar"])
(def street-suffix ["St." "Ave." "Way" "Drive"])

(defn random-name []
  (str
    (nth first-names (rand-int (count first-names))) " "
    (nth last-names (rand-int (count first-names)))))

(defn random-address []
  (str (rand-int 100)  " "
    (nth street (rand-int (count street))) " "
    (nth street-suffix (rand-int (count street-suffix)))))

(defn sample-data [n]
  (vec (flatten 
         (for [x (range n)] 
           {:name (random-name) :test (rand-int 500) :address (random-address)} ))))

