(ns muninn.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [muninn.core-test]))

(doo-tests 'muninn.core-test)
