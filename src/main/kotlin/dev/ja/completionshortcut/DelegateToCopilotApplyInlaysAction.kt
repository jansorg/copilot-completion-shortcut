package dev.ja.completionshortcut

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class DelegateToCopilotApplyInlaysAction : AnAction() {
    // We're not caching it because Copilot may be loaded or unloaded dynamically.
    // We don't want to prevent this and also would like to find the action after it was loaded dynamically.
    private val delegate: AnAction? get() = Actions.findCopilotApplyInlays()

    override fun getActionUpdateThread(): ActionUpdateThread {
        return delegate?.actionUpdateThread ?: ActionUpdateThread.BGT
    }

    override fun isDumbAware(): Boolean {
        return delegate?.isDumbAware == true
    }

    override fun update(e: AnActionEvent) {
        val delegate = delegate
        if (delegate != null) {
            delegate.update(e)
        } else {
            e.presentation.isEnabledAndVisible = false
        }
    }

    override fun actionPerformed(e: AnActionEvent) {
        delegate!!.actionPerformed(e)
    }
}
