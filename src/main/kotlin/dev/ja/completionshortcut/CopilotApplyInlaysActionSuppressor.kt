package dev.ja.completionshortcut

import com.intellij.codeInsight.lookup.LookupManager
import com.intellij.openapi.actionSystem.*


/**
 * Promotes actions to prefer the IDE's TAB over Copilot's TAB if completion of IDE and Copilot are shown at the same time.
 * Instead of attempting to override Copilot's own action promoter, it's suppressing the Copilot action when the following conditions are met:
 * - The completion popup is shown
 * - Copilot's "Apply inlays to editor" action is available, i.e. it's likely that Copilot inlays are visible
 * - Copilot's "Apply inlays to editor" action is bound to TAB
 */
class CopilotApplyInlaysActionSuppressor : ActionPromoter {
    private val preferredIdeActions = setOf("EditorTab", "EditorChooseLookupItemReplace", "ExpandLiveTemplateByTab")

    override fun suppress(actions: MutableList<out AnAction>, context: DataContext): MutableList<AnAction>? {
        val actionManager = ActionManager.getInstance()
        val project = CommonDataKeys.PROJECT.getData(context) ?: return null

        // don't suppress if no completion popup is shown
        LookupManager.getInstance(project).activeLookup ?: return null

        // don't suppress if no conflicting IDE action is available
        if (actions.none { actionManager.getId(it) in preferredIdeActions }) {
            return null
        }

        // don't suppress if Copilot action is not available
        val copilotAction = actions.firstOrNull { actionManager.getId(it) == Actions.COPILOT_APPLY_INLAYS_ACTION_ID }
            ?: return null

        // don't suppress if Copilot action is not bound to TAB
        if (actionManager.getKeyboardShortcut(Actions.COPILOT_APPLY_INLAYS_ACTION_ID) != Actions.TAB_SHORTCUT) {
            return null
        }

        // suppress Copilot action to prefer the IDE action
        return mutableListOf(copilotAction)
    }
}
