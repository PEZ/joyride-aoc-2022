(ns aoc2022-1
  (:require [util-aoc :as aoc]))

;; ## How to use this template
;; 0. Install the extensions Joyride and Calva
;; 1. Start and connect the Joyride nREPL server
;;    * Calva: Start Joyride REPL and Connect
;; 2. Open the file `util_aoc.cljs` and load it in the REPL
;;    * Calva: Load/Evaluate File (ctrl+alt+c enter)
;; 3. Then also load this file in the REPL
;; 4  Then evaluate the top level forms in the Rich Comment form
;;    (comment ...) below, in the order they appear

(comment
  ;; Initialize this AOC day, creates a statusbar item
  (aoc/set-day! 1)
  ;; You can click the item in to open the AOC site on day 1
  
  ;; Fetch your Day 1 input (If you haven't, first see README
  ;; for how to get your browser session here)
  (def real-input (aoc/fetched-input))

  ;; Give yourself some test input (copied from AOC Day 1)
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
  (aoc/update-indicator! "1" (part-1 test-input))
  (aoc/update-indicator! "1" (part-1 real-input))
  (part-2 test-input)
  (aoc/update-indicator! "2" (part-1 test-input))
  (aoc/update-indicator! "2" (part-1 real-input))
  :rcf)
