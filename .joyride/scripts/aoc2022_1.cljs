(ns aoc2022-1
  (:require [util-aoc :as aoc]))

;; Start by loading `util_aoc.cljs` in the REPL
;; (ctrl+alt+c enter)
;; Then load this file
;; Then evaluate the top level forms in the
;; Rich comment form `(comment ...)` below

(comment
  (aoc/set-day! 1)
  
  ;; See `util_aoc.cljs` for caveats re this `def`
  (def real-input (aoc/fetched-input))

  (def test-input [1000
                   2000
                   3000
                   nil
                   4000
                   nil
                   5000
                   6000
                   nil
                   7000
                   8000
                   9000
                   nil
                   10000])

  (defn part-1 [input]
    (->> input
         (partition-by nil?)
         (map (partial apply +))
         (apply max)))

  (defn part-2 [input]
    (->> input
         (partition-by nil?)
         (map (partial apply +))
         (sort >)
         (take 3)
         (apply +)))

  (part-1 test-input)
  (part-1 real-input)
  (aoc/inform! (part-1 real-input))
  (part-2 test-input)
  (part-2 real-input)
  (aoc/inform! (part-1 real-input))
  :rcf)


