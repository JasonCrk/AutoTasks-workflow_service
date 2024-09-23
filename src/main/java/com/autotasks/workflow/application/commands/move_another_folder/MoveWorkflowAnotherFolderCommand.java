package com.autotasks.workflow.application.commands.move_another_folder;

import com.autotasks.workflow.shared.domain.bus.command.Command;

public record MoveWorkflowAnotherFolderCommand(String id, String folderId) implements Command {
}
