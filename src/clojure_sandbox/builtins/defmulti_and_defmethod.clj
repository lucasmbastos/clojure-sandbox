(ns clojure-sandbox.builtins.defmulti-and-defmethod
  (:require [schema.core :as s]))

; defmulti and defmethod allows us to instantiate multiple methods with same name, this is useful to get benefits like
; overload and interfaces of OOP languages

; This function will check if parameter is even and apply custom function depending on value
(defmulti pow-different-even-odd even?)

; If number is even, we will apply a square
(defmethod pow-different-even-odd true
  [x]
  (* x x))

; Otherwise, if number is odd, we will apply a cube
(defmethod pow-different-even-odd false
  [x]
  (* x x x))

(println (pow-different-even-odd 2))                        ; 4
(println (pow-different-even-odd 3))                        ; 27
(println)

; When passing multiple arguments, we can use comp + list to get the exact argument
; Converting arguments to list, get first argument and checking if it is even
(defmulti multiply-or-sum-depending-of-first-argument (comp even? first list))

(defmethod multiply-or-sum-depending-of-first-argument true
  [x y]
  (* x y))

(defmethod multiply-or-sum-depending-of-first-argument false
  [x y]
  (+ x y))

(println (multiply-or-sum-depending-of-first-argument 4 5)) ; 20
(println (multiply-or-sum-depending-of-first-argument 5 4)) ; 9
(println)

; schema has a variant for defmulti allowing type checking
(s/set-fn-validation! true)

(defmulti pow-different-even-odd-only-positive even?)

(s/defmethod pow-different-even-odd-only-positive true :- s/Int
             [x :- s/Int]
             (* x x))

(s/defmethod pow-different-even-odd-only-positive false :- s/Int
             [x :- s/Int]
             (* x x x))

(println (pow-different-even-odd-only-positive 5))
; (println (pow-different-even-odd-only-positive 5.0))
(println (pow-different-even-odd-only-positive 2))
; (println (pow-different-even-odd-only-positive 2.0))
