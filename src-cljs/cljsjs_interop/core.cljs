(ns cljsjs-interop.core
    (:require [rum.core :as rum]
              [calculator :as calc]
              [appConfig]))

(enable-console-print!)

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(rum/defc hello-world < rum/reactive []
  [:div
   [:h1 (rum/react (rum/cursor app-state :text))]
   [:span "Author: " js/appConfig.author]
   [:h4 "Call from CLJS to JS function: 4 + 5 = " (js/calculator.add 4 5)]])

(rum/mount (hello-world)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; touch your app-state to force rerendering depending on
  ;; your application
  (swap! app-state update-in [:__figwheel_counter] inc))


(defn ^:export set-heading-text [str]
  (swap! app-state assoc :text str))