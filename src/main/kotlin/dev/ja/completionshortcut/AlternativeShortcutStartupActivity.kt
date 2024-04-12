package dev.ja.completionshortcut

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

/**
 * Load the Copilot action to avoid a warning about slow ness when it's done in our [DelegateToCopilotApplyInlaysAction]'s
 * update method.
 */
class AlternativeShortcutStartupActivity : StartupActivity, DumbAware {
    override fun runActivity(project: Project) {
        Actions.findCopilotApplyInlays()
    }
}