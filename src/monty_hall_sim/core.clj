(ns monty-hall-sim.core
  (:require [clojure.math.combinatorics :as combo])
  (:gen-class))

(def num-doors 3)

(defn create-outcomes [n]
  (let [v (vec (repeat (dec n) :goat))]
    (conj v :car)))

(defn init-game []
  (let [outcomes (create-outcomes num-doors)
        combo-outcomes (vec (combo/permutations outcomes))
        rand-combo (rand-nth combo-outcomes)
        choices (vec (map inc (range num-doors)))]
    (zipmap choices rand-combo)))

(defn monty-pick [game]
  (let [goats-only (into {} (filter #(= (second %) :goat) game))
        pick (rand-nth (keys goats-only))]
    {pick :goat}))

(defn play [switch?]
  (let [game (init-game)
        pick1 (inc (rand-int (count game)))
        reduced-game (dissoc game pick1)]
    (if switch?
      (let [mp (monty-pick reduced-game)]
        (->> mp
             (keys)
             (first)
             (dissoc reduced-game)
             (vals)
             (first)))
      (game pick1))))

(defn -main [times]
  (let [play-switch (into [] (repeatedly times #(play true)))
        switch-wins (count (filter #(= % :car) play-switch))
        play-noswitch (into [] (repeatedly times #(play false)))
        no-switch-wins (count (filter #(= % :car) play-noswitch))]
    {:switch (float (/ switch-wins times)) :no-switch (float (/ no-switch-wins times))}))
