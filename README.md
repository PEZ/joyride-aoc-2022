# Use VS Code and Joyride for Advent of Code 2022

[Joyride](https://github.com/BetterThanTomorrow/joyride) is en extension that lets you script VS Code like Emacs users script Emacs. Like with Emacs the scripting language is a LISP, making the programming fully interactive. The language is not ELisp, though. Instead something much nicer: [Clojure](https://clojure.org). Or, something more familiar to some of you: JavaScript.

[![Using VS Code for Solving Advent of Code, demo @ Agical](slides/images/Advent%20of%20Code%20Day%201%20at%20Agical%20VS%20Code%20Play.png)](https://www.youtube.com/watch?v=0rJvOtbJDyI)

^ Demo using this starter template ^

In the demo I use Clojure for solving Day 1. But you can use JavaScript if you like. Take a look at [.joyride/scripts/aoc2022_1_js.cljs](.joyride/scripts/aoc2022_1_js.cljs) and [.joyride/src/aoc/day-1.js](.joyride/src/aoc/day-1.js)which form a scaffold for how to do this.

## How to use this project

This is a template repository to make it quick and easy to get started using VS Code and Clojure to solve [Advent of Code](https://adventofcode.com/) problems.

### What's included

* A scaffold script for solving the two parts of Day 1: []()
* A utility namespace for loading your AOC problem input for any (released) day
* Instructions to guide you

### Prerequisites

* Curiosity
* VS Code, [with enough knowledge of how to use it, find commands and such](https://code.visualstudio.com/docs/introvideos/basics)
* A copy of this repository opened in VS Code

### What you need to add

Two VS Code extensions:

* [Joyride](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.joyride) - The scripting environment, which includes Clojure and an nREPL server
* [Calva](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva) - A Clojure IDE, which includes an nREPL client

Don't worry if you don't have a clue what nREPL is, I won't even link to it here. What ”you will have both a server and a client” means for you is that you don't need anything else to program in Clojure.

### Make your AOC browser extension avaliable to your scripts

To use the utility for downloading your AOC problems input, you will need to login to your AOC account and make that session available to the Joyride scripts. The utility script assumes a file named `.aoc-session` in the workspace root. This file should contain only the contents of the `session` cookie from the browser's session. A way to get at this cookie is:

1. Open the browser development console when you are logged in at https://adventofcode.com
2. Open the Networks tab
3. Reload the page
4. Click the resource you have reloaded, (`1` if it was the Day 1 problem page)
5. Look for the cookies in the request headers.
6. Copy the content (right click -> copy)
7. Paste the contents into the file `.aoc-session`

### Open the Day one problem script

In VS Code that is.

Depending on if you are going to solve the puzzle in Clojure or JavaScript

* **Clojure**:
    * [.joyride/scripts/aoc2022_1.cljs](.joyride/scripts/aoc2022_1.cljs)
* **JavaScript**:
    * [.joyride/scripts/aoc2022_1_js.cljs](.joyride/scripts/aoc2022_1_js.cljs) 
    * [.joyride/src/aoc/day-1.js](.joyride/src/aoc/day-1.js)

Then follow the instructions in the files.

## Joyride demo and repo with instructions

See this presentation with demo about what [Joyride](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.joyride) is and can do:

[![](https://github.com/PEZ/london-clojurians-joyride/raw/master/etc/London%20Clojurians%20Video%20Image.png)](https://www.youtube.com/watch?v=ObjIR08t3lg)

* Examples from that demo, with instructions: https://github.com/PEZ/london-clojurians-joyride
* Demo: https://www.youtube.com/watch?v=ObjIR08t3lg
* Joyride repository: https://github.com/BetterThanTomorrow/joyride

## License

All content in this repository is free to use as you see fit. At your own risk.

## Happy Joyriding! 🚗💨

Please join the `#joyride` channel on [Clojurians Slack](http://clojurians.net) to get help, provide feedback, and share your solutions. You can also reach us in the [Discussions section](https://github.com/BetterThanTomorrow/joyride/discussions) of the Joyride repository.

