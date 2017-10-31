# cljsjs-interop

Example project on cljsjs-interop
Prepared for FP-Monthly presentation at [https://www.solita.fi](Solita Oy), Oct 2017

## Overview

Instantiated from

   lein new figwheel cljsjs-interop -- --rum

+ added :foreign-libs keyword into :compiler options

   :foreign-libs [{:file "src-js"}]

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2017 Solita Oy, Jouni Honkala

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
