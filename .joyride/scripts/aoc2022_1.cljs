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
  ;; 2.1 Now you can look at this input by evaluating the `real-input` symbol
  ;;     Place the cursor in, or adjacent to, the symbol and:
  ;;     Use the command: Calva: Evaluate current form (ctrl+enter)

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

  ;; 4B. Implement part-1, this function should evaluate to (return)
  ;;     your answer when called with `input`
  ;;     (a list of numbers or `nil`s in the case of Day 1).
  ;;     First evaluate the current implementation.
  ;;     You can try it out without editing this first, if you like.
  ;;     (That's why the numbering is a bit funny. 😀)
  (defn part-1 [input]
    (first input) ; <- Probably the wrong answer
    )

  ;; 4A. Test your implementation of Part 1
  (part-1 test-input)
  (aoc/update-indicator! "1" (part-1 test-input))
  (aoc/update-indicator! "1" (part-1 real-input))

  ;; 5B. Implement part-2
  (defn part-2 [input]
    (last input) ; <- Good try, but wrong!
    )
  
  ;; 5A. Test your implementation of Part 1
  (part-2 test-input)
  (aoc/update-indicator! "2" (part-2 test-input))
  (aoc/update-indicator! "2" (part-2 real-input))
  :rcf)
