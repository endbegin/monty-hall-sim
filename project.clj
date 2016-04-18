(defproject monty-hall-sim "0.1.0"
  :description "A simulation of the Monty Hall problem"
  :url "http://github.com/endbegin/monty-hall-sim"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.combinatorics "0.1.1"]]
  :main ^:skip-aot monty-hall-sim.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
