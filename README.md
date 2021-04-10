# An example how to use CLJS and REPL to develop extensions for VSCode

Instructions how to easily develop VSCode extensions using [Calva](https://github.com/BetterThanTomorrow/calva) and [Shadow-cljs](https://github.com/thheller/shadow-cljs)

## Setup

After cloning the repo and opening it in VSCode:

1. Install dependencies by running `npm install`
2. In VSCode, `Calva: Start a project REPL and Connect (aka Jack-In)`
3. Select `:dev` from the `Select builds to start` -option list
4. Wait **UNTIL** shadow-cljs finishes the build: `[:dev] Build completed. (84 files, 1 compiled, 0 warnings, 1.81s)` (or something like this)
5. Start extension debug session in VSCode:
   1. Select `Run and Debug`
   2. Select `Start Debugging: Run Extension`
   3. VSCode opens a new debug instance of itself. From that new window execute the extension command (from the command palette): `Hello World`
   4. You should see the `Hello World!` info window to popup. Now VSCode has loaded the compiled JS code
6. In the original VSCode window, select `:dev` from the REPL-list that Calva has prompted during the Jack-In process.
7. Open the `main.cljs` file and load the CLJS extension code to the repl with Calva by running the command `Calva: Load Current File and Dependencies`
8. Now the REPL is ready. Try to use the native VSCode API to show another info popup by running `(.. vscode -window (showInformationMessage "Another info popup!"))` inside the `comment`-form in `main.cljs`:
   1. Take caret to the end of the form you want to execute: `(.. vscode -window (showInformationMessage "Another info popup!"))`
   2. Execute the command: `Calva: Evaluate Current Form (or selection, if any)`
   3. Now you should see the new info popup to show in the VSCode debug instance window

The info popups will be shown in the VSCode debug instance and console logs can be found in the `Debug Console` of the VSCode instance that you use for development.
