(ns util-aoc
  (:require ["https" :as https]
            ["util" :as node-util]
            ["vscode" :as vscode]
            [clojure.edn :as edn]
            [promesa.core :as p]
            [clojure.string :as string]))

(defonce !state (atom {:day nil
                       :input nil
                       :indicator nil}))

(defn fetched-input []
  (:input @!state))

(defmacro def-promise-value
  "To be able to handle the input promise as a raw value in the
   solution code...
   Might blow up at the first run before the input is memoized."
  [name & body]
  `(.then (do ~@body) #(def ~name %)))

(defn slurp-ws-file+ [ws-file]
  (-> (p/let [ws-root (-> vscode/workspace.workspaceFolders first .-uri)
              uri (vscode/Uri.joinPath ws-root ws-file)
              data (vscode/workspace.fs.readFile uri)
              text (.decode (js/TextDecoder. "utf-8") data)]
        text)
      (p/catch (fn [e]
                 (println "Ho, ho, ho! File not found:" ws-file e)
                 (throw (js/Error. e))))))

#_{:clj-kondo/ignore [:unused-private-var]}
(defn- open-aoc-day! [day answer]
  (if answer
    (p/let [choice (vscode/window.showInformationMessage
                    (str "Ho, ho, ho! Copy " answer " to the clipboard and open day " day " on adventofcode.com?")
                    "Yes, please")]
      (when choice
        (-> (vscode/env.clipboard.writeText (str answer))
            (.then #(vscode/env.openExternal (str "https://adventofcode.com/2022/day/" day))))))
    (vscode/env.openExternal (str "https://adventofcode.com/2022/day/" day))))

(comment
  (require '["http" :as http])
  :rcf)
(defn- fetch-input'+ [day]
  (-> (p/let [cookie (slurp-ws-file+ ".aoc-session")
              get+ (node-util/promisify https/get)
              incoming-message (get+ #js {:hostname "adventofcode.com"
                                          ;:hostname "localhost"
                                          :method "GET"
                                          :port 443
                                          :path (str "/2022/day/" day "/input")
                                          :headers #js {:Cookie (str "session=" cookie)}})
              data (.read incoming-message)
              input (.toString data)]
        input)
      ;; TODO: No idea why this ends up in the p/catch clause!
      (p/catch (fn [x]
                (if (> (.-statusCode x) 300)
                  (do (println "Ho, ho, ho! Did you forget to populate `.aoc-session` with your AOC session cookie?" x)
                      (throw (js/Error. x)))
                  (p/let [data (.read x)
                          input (.toString data)]
                    input))))))

(comment
  (fetch-input'+ 1)
  :rcf)

(def fetch-input+
  (memoize fetch-input'+))

(defn- read-string-or-string
  "Returns `s` as read by `edn/read-string` if that works,
   otherwise returns `s`"
  [s]
  (try
    (edn/read-string s)
    (catch :default _e
      s)))

(defn values+
  "Returns (resolves to) the input for `day` as
   a sequence of values (if they parse as proper EDN)"
  [day]
  (-> (p/let [values (fetch-input+ day)]
        (->> values
             (string/split-lines)
             (map read-string-or-string)))
      (p/catch (fn [e]
                 (println "Ho ho ho!" day e)
                 (println e)))))

(comment
  (values+ 1)
  :rcf)

(defn update-indicator!
  [part answer]
  (let [{:keys [day indicator]} @!state]
    (set! (.-text indicator) (str "Day " day ", part " part ": " answer))
    (set! (.-tooltip indicator)
          (str "Advent of Code 2022, day " day ", part " part ". "
               "Want to check if " answer " is the correct answer for your input?"))
    (set! (.-command indicator)
          #js {:command "joyride.runCode"
               :arguments #js [(str "(util-aoc/open-aoc-day! " 
                                    day " " answer")")]})
    answer))

(defn create-indicator! [day]
  (when-let [existing-indicator (:indicator @!state)]
    (.dispose existing-indicator)
    (swap! !state assoc :indicator nil))
  (p/let [indicator (vscode/window.createStatusBarItem
                vscode/StatusBarAlignment.Left
                -1000)]
    (set! (.-text indicator) (str "Day " day ": <go-for-it>"))
    (set! (.-tooltip indicator) (str "Advent of Code 2022, day, " day ". Waiting for you to test your solution..."))
    (set! (.-command indicator)
          #js {:command "joyride.runCode"
               :arguments #js [(str "(util-aoc/open-aoc-day! " day ")")]})
    (.show indicator)
    indicator))

(defn set-day!
  [d]
  (p/let [indicator (create-indicator! d)
          input (values+ d)]
    (println "Initializing day" (str d "!"))
    (swap! !state assoc
           :day d
           :input input
           :indicator indicator)))

(defn inform!
  "Show an information message with `x`"
  [x]
  (vscode/window.showInformationMessage (str x)))

(comment
  (slurp-ws-file+ ".aoc-session")
  (values+ 1)
  @!state
  (set-day! 1)
  (create-indicator! 1)
  :rcf)

