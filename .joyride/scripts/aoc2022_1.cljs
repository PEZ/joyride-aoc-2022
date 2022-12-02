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
;;    (comment ...) below, in the order they appear.
;;
;;    To evaluate a top level form, place the cursor somewhere
;;    in the form and use the command:
;;    * Calva: Evaluate Current Form (alt+enter)

(comment
  ;; 1. Initialize this AOC day, creates a statusbar item
  ;;    (alt+enter with the cursor in, or adjacent to, the form below)
  (aoc/set-day! 1)
  ;; You can now click the item to open the AOC site on day 1

  ;; 2. Fetch your Day 1 input (If you haven't, see README
  ;; for how to get make your browser session available to the REPL)
  (def real-input (aoc/fetched-input))

  ;; 3. Give yourself some test input (copied from AOC Day 1)
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

  ;; 4A. Implement part-1, this function should evaluate to (return)
  ;;    your answer when called with `input`
  ;;    (a list of numbers or `nil`s in the case of Day 1).
  ;;    You can try 4B without editing this first, if you like.
  (defn part-1 [input]
    (first input) ; <- Probably the wrong answer
    )

  ;; 4B. Test your implementation
  (part-1 test-input)
  (aoc/update-indicator! "1" (part-1 test-input))
  (aoc/update-indicator! "1" (part-1 real-input))

  (defn part-2 [input]
    (last input) ; <- Good try, but wrong!
    )
  
  (part-2 test-input)
  (aoc/update-indicator! "2" (part-1 test-input))
  (aoc/update-indicator! "2" (part-1 real-input))
  :rcf)
