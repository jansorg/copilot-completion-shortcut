# Alternative Shortcut for GitHub Copilot

Make `TAB` insert the completion popup item instead of GitHub Copilot inlays, if both are visible at the same time.

With setting `Show completions side-by-side` enabled and using the `TAB` shortcut,
the GitHub Copilot plugin prefers its own inlay completions over the IDE's completions.

This plugin enforces that TAB is inserting the selected completion of the IDE's popup menu instead.
But if you'd like to insert the GitHub Copilot completion, you can use the newly added `SHIFT+TAB` shortcut.

If you want to use something else than `SHIFT+TAB`, then you add your own shortcut at `Settings > Keymap > Plugins > Copilot Shortcut > Copilot: Apply completion to editor (alternative shortcut)`.

## With This Plugin

`TAB` executes the IDE's "Replace with selected completion item" instead of "Apply GitHub Copilot inlays".

|                                    | IDE Completion Popup | Copilot Inlays | Completion Popup + Copilot Inlays |
|------------------------------------|----------------------|----------------|-----------------------------------|
| Replace with completion popup item | TAB                  | —              | TAB                               |
| Insert Copilot inlays              | —                    | TAB            | SHIFT + TAB                       |

## Without This Plugin

`TAB` executes "Apply GitHub Copilot inlays" instead of the IDE's "Replace with selected completion item".

|                                    | IDE Completion Popup | Copilot Inlays | Completion Popup + Copilot Inlays |
|------------------------------------|----------------------|----------------|-----------------------------------|
| Replace with completion popup item | TAB                  | —              | *not possible*                    |
| Insert Copilot inlays              | —                    | TAB            | TAB                               |
