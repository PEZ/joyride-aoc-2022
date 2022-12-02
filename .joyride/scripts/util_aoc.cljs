(ns util-aoc
  (:require ["vscode" :as vscode]
            ["requestify" :as fetch]
            [clojure.edn :as edn]
            [promesa.core :as p]
            [clojure.string :as string]))

(defonce !state (atom {:day nil
                       :input nil
                       :statusbar-item nil}))

(defn fetched-input []
  (:input @!state))

(defmacro def-promise-value
  "To be able to handle the input promise as a raw value in the
   solution code...
   Might blow up at the first run before the input is memoized."
  [name & body]
  `(.then (do ~@body) #(def ~name %)))

(defn slurp-ws-file+ [ws-file]
  (->
   (p/let [ws-root (-> vscode/workspace.workspaceFolders first .-uri)
           uri (vscode/Uri.joinPath ws-root ws-file)
           data (vscode/workspace.fs.readFile uri)
           text (.decode (js/TextDecoder. "utf-8") data)]
     text)
   (p/catch (fn [e]
              (println "Ho, ho, ho! File not found:" ws-file e)
              (throw (js/Error. e))))))

(defn- fetch-input'+ [day]
  (->
    (p/let [cookie (slurp-ws-file+ ".aoc-session")
            response (.get requestify
                           (str "https://adventofcode.com/2022/day/" day "/input")
                           #js {:cookies #js {:session cookie}})]
      (.getBody response))
    (p/catch (fn [e]
               (println "Ho, ho, ho! Did you forget to populate `.aoc-session` with your AOC session cookie?" e)
               (throw (js/Error. e))))))

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
  (p/let [values (fetch-input+ day)]
    (->> values
         (string/split-lines)
         (map read-string-or-string))))

(defn set-day!
  [d]
  (p/let [input (values+ d)]
    (swap! !state assoc
           :day d
           :input input)))

(defn inform!
  "Show an information message with `x`"
  [x]
  (vscode/window.showInformationMessage (str x)))

(comment
  (slurp-ws-file+ ".aoc-session")
  (values+ 1)
  (fetch-input+ 1)
  (fetch-input'+ 1)
  :rcf)

