(ns cljs-vscode-extension.main
  (:require ["vscode" :as vscode]))

(defn hello-world []
  (.. vscode -window (showInformationMessage "Hello World!")))

(defn activate [^js/vscode.ExtensionContext context]
  (.log js/console "Congratulations, cljs-vscode-extension is now active!")

  (let [disposable (.. vscode -commands (registerCommand "cljs-vscode-extension.main.helloWorld" #'hello-world))]
    (.. context -subscriptions (push disposable))))

(defn deactivate [])

(defn ^:dev/after-load reload []
  (.log js/console "Clearning JS cache...")
  (js-delete js/require.cache (js/require.resolve "./main")))

(def exports #js {:activate activate
                  :deactivate deactivate})

(comment
  
  ;; To test that REPL works :)
  (.. vscode -window (showInformationMessage "Another info popup!"))
  (js-keys vscode)
  (js-keys (.. vscode -window))
  .)
