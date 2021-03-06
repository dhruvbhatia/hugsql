(ns hugsql.adapter.clojure-jdbc
  (:gen-class)
  (:require [hugsql.adapter :as adapter]
            [jdbc.core :as jdbc]))

(deftype HugsqlAdapterClojureJdbc []

  adapter/HugsqlAdapter
  (execute
    [this db sqlvec options]
    (apply jdbc/execute db sqlvec (:command-options options)))

  (query
    [this db sqlvec options]
    (apply jdbc/fetch db sqlvec (:command-options options)))

  (result-one [this result options]
    (first result))

  (result-many [this result options]
    result)

  (result-affected [this result options]
    result)

  (result-raw [this result options]
    result)

  (on-exception [this exception]
    (throw exception)))

(defn hugsql-adapter-clojure-jdbc []
  (->HugsqlAdapterClojureJdbc))
