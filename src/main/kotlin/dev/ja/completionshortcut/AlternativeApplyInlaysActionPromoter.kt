package dev.ja.completionshortcut

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionPromoter
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.DataContext

/**
 * Promote our alternative shortcut SHIFT+TAB over actions like de-indent.
 * This allows to use shortcuts like SHIFT+TAB to apply Copilot's inlays if both the IDE completions popup and Copilot's inlays are shown.
 */
class AlternativeApplyInlaysActionPromoter : ActionPromoter {
    override fun promote(actions: MutableList<out AnAction>, context: DataContext): MutableList<AnAction>? {
        val actionManager = ActionManager.getInstance()
        val alternativeApplyAction = actions.firstOrNull { actionManager.getId(it) == Actions.ALTERNATIVE_SHORTCUT_ACTION_ID }
            ?: return null
        return mutableListOf(alternativeApplyAction)
    }
}
