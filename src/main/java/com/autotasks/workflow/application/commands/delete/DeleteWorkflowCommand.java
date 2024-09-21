package com.autotasks.workflow.application.commands.delete;

import com.autotasks.workflow.shared.domain.bus.command.Command;

public record DeleteWorkflowCommand(
        String id
) implements Command {
}
