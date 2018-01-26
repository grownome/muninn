(ns muninn.views
  (:require [re-frame.core :as re-frame]
            [muninn.subs :as subs]
            [cljsjs.material-ui]
            [cljsjs.victory :as v]
            [cljs-react-material-ui.core :refer [get-mui-theme color]]
            [cljs-react-material-ui.reagent :as ui]
            [cljs-react-material-ui.icons :as ic]
            [reagent.core :as r]))

;; home

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [ui/mui-theme-provider
     {:mui-theme (get-mui-theme {:palette {:text-color (color :green600)}})}
     [:div
      [ui/app-bar {:title "Grownome"}]
      [ui/paper
       [ui/card
        [ui/card-header {:title "A sensor"}]
        [(r/as-element v/VictoryPie)]
        [ui/card-text "This is your plant data"]]
       ]
            ]

     ]



    ))



;; about

(defn about-panel []
  [:div "This is the About Page."
   [:div [:a {:href "#/"} "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
