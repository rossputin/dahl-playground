(defproject omnom "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.8.0"]
                 [re-frame "0.10.5"]
                 [day8.re-frame/http-fx "0.1.6"]
                 [com.cemerick/url "0.1.1"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.15"]]
  :hooks [leiningen.cljsbuild]
  :source-paths ["src-cljc"]
  :profiles {:dev {:cljsbuild {:builds {:client {:figwheel {:on-jsload "omnom.core/run"}
                                                 :compiler {:main "omnom.core"
                                                            :asset-path "js"
                                                            :optimizations :none
                                                            :source-map true
                                                            :source-map-timestamp true}}}}}
             :prod {:cljsbuild {:builds {:client {:compiler {:optimizations :advanced
                                                             :elide-asserts true
                                                             :pretty-print false}}}}}}
  :figwheel {:repl false}
  :clean-targets ^{:protect false} ["resources/public/js"]
  :cljsbuild {:builds {:client {:source-paths ["src-cljs"]
                                :compiler     {:output-dir "resources/public/js"
                                               :output-to  "resources/public/js/omnom.js"}}}})
