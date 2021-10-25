(ns clojure-sandbox.builtins.destructuring)

(def my-list ["Slark" "Kunkka" "Mars" "Ogre Magi" "Disruptor"])
(println my-list)
(println)

; This is the simplest way of destructuring
(defn destruct1
  [[pos-1 pos-2 pos-3 pos-4 pos-5]]
  (println pos-1)
  (println pos-2)
  (println pos-3)
  (println pos-4)
  (println pos-5)
  (println))

(destruct1 my-list)

; We don't need to address all positions
(defn destruct2
  [[pos-1 pos-2]]
  (println pos-1)
  (println pos-2)
  (println))

(destruct2 my-list)

; We can use the '&' character to bind the rest of list
(defn destruct3
  [[pos-1 pos-2 & remaining-positions]]
  (println pos-1)
  (println pos-2)
  (println remaining-positions)
  (println))
(destruct3 my-list)

; We can ignore items
(defn destruct4
  [[pos-1 _ pos-3 _ pos-5]]
  (println pos-1)
  (println pos-3)
  (println pos-5)
  (println))
(destruct4 my-list)

; Last but not least we can bind full vector in another symbol even with destructing
(defn destruct5
  [[pos-1 pos-2 :as all-heroes]]
  (println pos-1)
  (println pos-2)
  (println all-heroes)
  (println))
(destruct5 my-list)
