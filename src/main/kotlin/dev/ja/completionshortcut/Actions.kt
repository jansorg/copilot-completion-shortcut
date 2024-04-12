package dev.ja.completionshortcut

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.KeyboardShortcut

internal object Actions {
    const val COPILOT_APPLY_INLAYS_ACTION_ID = "copilot.applyInlays"
    const val ALTERNATIVE_SHORTCUT_ACTION_ID = "dev.ja.alternativeCompletionShortcut"
    val TAB_SHORTCUT: KeyboardShortcut = KeyboardShortcut.fromString("TAB")

    fun findCopilotApplyInlays(): AnAction? {
        return ActionManager.getInstance().getAction(COPILOT_APPLY_INLAYS_ACTION_ID)
    }
}