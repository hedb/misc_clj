(ns misc_clj.core

  (:require [clojure.algo.generic.math-functions :refer [pow]]))

;; https://projecteuler.net/problem=6

(defn square-sum [list-to-sum]
  (pow (reduce + list-to-sum) 2))

(defn sum-squares [list-to-sum]
  (reduce + (map #(pow % 2) list-to-sum))
)

(defn diff-sums [list-to-sum]
  (- (square-sum list-to-sum) (sum-squares list-to-sum) )
  )


(comment
  ;; Sandbox

  (format "%f" (diff-sums (range 101)))

  (and
   (= (square-sum (range 11)) 3025.0)
   (= (sum-squares (range 11)) 385.0)
   (= (diff-sums (range 11)) 2640.0)
   )

  )
