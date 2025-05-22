(ns user
  "The user namespace for development."
  (:require [clojure.pprint :as pp]
            [clojure.reflect :as cr])
  ;; Ideally, require nothing here (see jit macro)
  )

;;; You cannot (set! *print-namespace-maps* false) here, because (as per Alex Miller)
;;; dynamic vars have to be bound at the root before you can rebind them dynamically.
;;; The repl binds a bunch of dyn vars for you but user.clj is loaded before the repl.
;;; Therefore ...
(defmethod print-method clojure.lang.IPersistentMap [m, ^java.io.Writer w]
  "From https://clojuredocs.org/clojure.core/*print-namespace-maps*"
  (#'clojure.core/print-meta m w)
  (#'clojure.core/print-map m #'clojure.core/pr-on w))

;; Stolen from @plexus, with some mods.

(defmacro jit
  "Just in time loading of dependencies.
  Enables fast time to get a repl prompt.
  Also, makes sure you don't do much in this file,
  other than define some functions/macros.
  NOTE: does not work on macros."
  [sym]
  `(requiring-resolve '~sym))

(comment
  (set! *warn-on-reflection* true)

  ;; do not put logging in the :require since it interacts badly with cider/nrepl
  (require '[clojure.tools.logging :as log])
  (require '[{{top/ns}}.{{main/ns}} :as {{main/ns}}] :reload)
  )
