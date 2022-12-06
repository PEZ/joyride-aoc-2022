(ns aoc2022-1-js
  (:require [aoc.util :as aoc])
  (:require ["../src/aoc/day-1.js" :as day-1] :reload)
  )

;; Joyride AOC part 1 control panel for JavaScript developers
;; This file requires a JavaScript file for the implementation
;; of the solutions. So you can stick to familiar ground
;; and just use this file as a command panel.

;; ## How to use this template
;; 0. Install the extensions Joyride and Calva
;; 1. Start and connect the Joyride nREPL server
;;    * Calva: Start Joyride REPL and Connect
;;      ^ You find this command in the Command Palette (F1)    
;; 2. Load this file in the REPL
;;    * Calva: Load/Evaluate File (ctrl+alt+c enter)
;; 3  Then evaluate the top level forms inside the Rich Comment form
;;    (comment ...) below, in the order they appear.
;;
;;    You can think of a "form" as either a literal, a symbol
;;    or anything in brackets/parens, including the brackets.
;;    A top-level form is a form that starts and ends in the
;;    the file ”scope”, or directly inside a `(comment ...)`.
;;
;;    To evaluate a top level form, place the cursor somewhere
;;    in the form and use the command:
;;    * Calva: Evaluate Current Form (alt+enter)

(comment
  ;; 1. Initialize this AOC day, creates a statusbar item
  ;;    (alt+enter with the cursor in, or adjacent to,
  ;;     the form below, which is a top-level form)
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
    (day-1/part_1 (clj->js input)) ; <- Implement in ../src/aoc/day-1.js
    )
  ;; Every time you have updated the JavaScript code, do the following
  ;; to use the new definition:
  ;; 1. Reload this file in the REPL (ctrl+alt+c enter)
  ;; 2. Re-evaluate the above top-level form (defn part-1 ...)

  ;; 4A. Test your implementation of Part 1
  ;; Check the status bar indicator before and after evaluating
  ;; this top-level form. The indicator button will change title.
  ;; And clicking it will offer to copy the answer to the clipboard
  ;; and take you to Day 1 on the AOC site, where you can paste it.
  (aoc/update-indicator! "1" (part-1 test-input))
  
  ;; Of course, you want to copy and paste the answer when using
  ;; `real-input` instead:
  (aoc/update-indicator! "1" (part-1 real-input))

  ;; 5B. Implement part-2
  (defn part-2 [input]
    (day-1/part_2 (clj->js input)) ; <- Implement in ../src/aoc/day-1.js
    )

  ;; 5A. Test your implementation of Part 1
  (aoc/update-indicator! "2" (part-2 test-input))
  (aoc/update-indicator! "2" (part-2 real-input))
  :rcf)
