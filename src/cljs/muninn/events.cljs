(ns muninn.events
  (:require [re-frame.core :as re-frame]
            [muninn.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 ::set-user
 (fn [db [_ new-user]]
   (assoc db :user new-user)))

(re-frame/reg-event-fx
 ::sign-in
 (fn [_ _] {:firebase/google-sign-in {:sign-in-method :popup}}))

(re-frame/reg-event-fx
 ::sign-out
 (fn [_ _] {:firebase/sign-out nil}))
