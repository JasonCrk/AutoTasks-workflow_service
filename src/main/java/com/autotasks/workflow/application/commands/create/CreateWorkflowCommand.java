package com.autotasks.workflow.application.commands.create;

import com.autotasks.workflow.shared.domain.bus.command.Command;

public record CreateWorkflowCommand(
        String id,
        String name,
        String folderId
) implements Command {
}
