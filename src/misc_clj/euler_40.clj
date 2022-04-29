(ns misc-clj.euler-40
  
  
  (:require [clojure.algo.generic.math-functions :refer [pow, floor,log]]))

;; https://projecteuler.net/problem=40
;; https://docs.google.com/spreadsheets/d/1mDqF7v_Pg2TX0YYEkHJE7mAf0TkCziVmi9QWwB-CKdo/edit#gid=0


(defn my-log [x b]
  (/ (log x) (log b))
  )

(defn get-i-digit-from-n [n i]  
    ;; 512: 2 is the 0 digit, 1 is the 1 digit, 5 is the 2 digit
    (-
     (floor (/ n (pow 10 i)))
     (* 10 (floor (/ n (pow 10 (+ i 1)))))
     )
  )

(defn get-n-digit [n]

  (let [x
        (first (filter
                #(>= (second %) n)
                (reductions
                 #(do [(first %2) (+ (second %1) (second %2)) (- (+ (second %1) (second %2)) n)])
                 (map
                  #(do [% (+ (floor (my-log % 10)) 1)])
                  (range 1 n)))))]
    (get-i-digit-from-n (first x) (nth x 2)))


  )


(comment
  ;; Sandbox



  (get-n-digit n)

  (map #(do [% (+ (floor (my-log % 10)) 1)]) (range 1 n))

  (range 10)

  (let [n 512 i 3]
    ;; 512: 2 is the 0 digit, 1 is the 1 digit, 5 is the 2 digit
    (-
     (floor (/ n (pow 10 i)))
     (* 10 (floor (/ n (pow 10 (+ i 1)))))))

  (and
   (= (get-i-digit-from-n 512 0) 2.0)
   (= (get-i-digit-from-n 512 1) 1.0)
   (= (get-i-digit-from-n 512 2) 5.0)

   (= (get-n-digit 12) 1.0)
   (= (get-n-digit 15) 2.0))


  (* 1  1 (get-n-digit 100) (get-n-digit 1000) (get-n-digit 10000) (get-n-digit 100000)
    (get-n-digit 1000000) )





  (def n 10)

  (let [x
        (first (filter
                #(>= (second %) n)
                (reductions
                 #(do [(first %2) (+ (second %1) (second %2)) (- (+ (second %1) (second %2)) n)])
                 (map
                  #(do [% (+ (floor (my-log % 10)) 1)])
                  (range 1 n)))))]
    (get-i-digit-from-n (first x) (nth x 2))
    )




  )
  