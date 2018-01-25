(ns muninn.db
  (:require [clojure.spec.alpha :as s]))

(s/def ::display-name string?)
(s/def ::email        string?)
(s/def ::photo-url    string?)
(s/def ::uuid         string?)

(s/def ::user
  (s/keys :req-un [::display-name
                   ::email
                   ::photo-url
                   ::uid]))
(s/def ::db
  (s/keys :req-un [::user]))

(def default-db
  {:name "Grownome - Muninn"})
