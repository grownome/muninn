(ns muninn.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [com.degel.re-frame-firebase :as firebase]
            [muninn.events :as events]
            [muninn.routes :as routes]
            [muninn.views :as views]
            [muninn.config :as config]))

(defonce firebase-app-info
  {:apiKey "AIzaSyAYBypBI6IOqw8QebFhYRbI5GiyK2qIkCI"
   :authDomain "grownome.firebaseapp.com"
   :databaseURL "https://grownome.firebaseio.com"
   :projectId "grownome"
   :storageBucket "grownome.appspot.com"
   :messagingSenderId "41380968732"})


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (firebase/init :firebase-app-info firebase-app-info
                 :get-user-sub [:muninn.subs/user]
                 :set-user-event  [:muninn.events/set-user]
                 :default-error-handler [:firebase-error])
  (mount-root))
