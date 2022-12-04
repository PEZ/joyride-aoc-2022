# Use VS Code and Joyride for Advent of Code 2022

[Joyride](https://github.com/BetterThanTomorrow/joyride) is en extension that lets you script VS Code like Emacs users script Emacs. Like with Emacs the scripting language is a LISP, making the programming fully interactive. The language is not ELisp, though. Instead something much nicer: [Clojure](https://clojure.org).

[![Using VS Code for Solving Advent of Code, demo @ Agical](slides/images/Advent%20of%20Code%20Day%201%20at%20Agical%20VS%20Code%20Play.png)](https://www.youtube.com/watch?v=0rJvOtbJDyI)

^ Demo using this starter template ^

## How to Joyride use this project

This is a template repository to make it quick and easy to get started using VS Code and Clojure to solve [Advent of Code](https://adventofcode.com/) problems.

### What's included

* A scaffold script for solving the two parts of Day 1: []()
* A utility namespace for loading your AOC problem input for any (released) day
* Instructions to guide you

### Prerequisites

* Curiosity
* VS Code
* A copy of this repository opened in VS Code
* Node

### What you need to add

Two VS Code extensions:

* [Joyride](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.joyride) - The scripting environment, which includes Clojure and an nREPL server
* [Calva](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva) - A Clojure IDE, which includes an nREPL client

Don't worry if you don't have a clue what nREPL is, I won't even link to it here. What ”you will have both a server and a client” means for you is that you don't need anything else to program in Clojure. (You might object that Node is needed in the list above, but it is only needed to install some npm modules that the utility script (somewhat unnecessarily) depends on.)

### Install node module dependencies

The AOC utilities script relies on two npm modules, `requestify` and `open`. From the root of the project:

```sh
$ cd .joyride
$ npm i
$ cd ..
```

### Make your AOC browser extension avaliable to your scripts

To use the utility for downloading your AOC problems input, you will need to login to your AOC account and make that session available to the Joyride scripts. The utility script assumes a file named `.aoc-session` in the workspace root. This file should contain only the contents of the `session` cookie from the browser's session. A way to get at this cookie is:

1. Open the dev console when you are logged in at adventofcode.com
2. Open the Networks tab
3. Reload the page
4. Click the resource you have reloaded, (`1` if it was the Day 1 problem page)
5. Look for the cookies in the request headers.
6. Copy the content (right click -> copy)
7. Paste the contents into the file `.aoc-session`
8. Clean away everything except the content of the cookie named `session`. Everything. So `session=` and any `;` and newlines should be removed. (It is pretty easy to update the utility functions to do this cleaning for you, but it is not done yet.) You should have one line with only hex didgits in this file when you are done.)

### Open the Day one problem script

In VS Code that is.

* [.joyride/scripts/aoc2022_1.cljs](.joyride/scripts/aoc2022_1.cljs)

Follow the instructions in this file

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

