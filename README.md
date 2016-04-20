# monty-hall-sim

This is a simulation of the Monty-Hall problem. See https://en.wikipedia.org/wiki/Monty_Hall_problem for a description.

## Installation

Clone, and create a JAR file with "lein uberjar"

## Usage

    $ java -jar monty-hall-sim-0.1.0-standalone.jar times

where 'times' is the number of times to run the game.

The result of the simulation is a clojure map that displays the percentage of wins if the player switched and did not switch.

For example, during a sample run of 1000 games, here is a possible result:

    {:switch 0.648, :no-switch 0.304}

This means that when a player won 64.8% of the time upon switching but only 30.4% of the time when sticking to their guns.
Due to the random nature of the game, these numbers will vary slightly.

For increasing values of 'times', the switch-win percentage will settle to 67% - meaning you win 2/3 of the time when you switch.
 If this seems obvious, take a look at this humorous account: http://marilynvossavant.com/game-show-problem/

## License
Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
