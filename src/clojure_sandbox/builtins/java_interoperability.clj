(ns clojure-sandbox.builtins.java-interoperability
  (:import (java.time LocalDateTime)))

; url: https://clojure.org/reference/java_interop


; StaticMethods are called with this template (Classname/staticField args*) args* are optional
(defn now
  []
  (LocalDateTime/now))

(println (now))

; Class and instance methods are called with this template
; (.instanceMember Classname args*) or (.instanceMember instance args*)

(defn with-year
  [datetime year]
  (.withYear datetime year))

(println (with-year (now) 1999))

; We can use "^" to give type-hint in methods with overload
(defn abs
  [^Double x]
  (Math/abs x))

; Will be converted to 14.0
(println (abs 14))