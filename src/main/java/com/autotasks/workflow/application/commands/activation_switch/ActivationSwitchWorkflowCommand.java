package com.autotasks.workflow.application.commands.activation_switch;

import com.autotasks.workflow.shared.domain.bus.command.Command;

public record ActivationSwitchWorkflowCommand(
        String id
) implements Command {
}
