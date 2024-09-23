package com.autotasks.workflow.application.commands.move_another_folder;

import com.autotasks.workflow.domain.value_objects.WorkflowFolderId;
import com.autotasks.workflow.domain.value_objects.WorkflowId;

import com.autotasks.workflow.shared.domain.Service;
import com.autotasks.workflow.shared.domain.bus.command.CommandHandler;

@Service
public final class MoveWorkflowAnotherFolderCommandHandler
        implements CommandHandler<MoveWorkflowAnotherFolderCommand, Void> {

    private final WorkflowMoverAnotherFolder moverAnotherFolder;

    public MoveWorkflowAnotherFolderCommandHandler(WorkflowMoverAnotherFolder moverAnotherFolder) {
        this.moverAnotherFolder = moverAnotherFolder;
    }

    @Override
    public Void handle(MoveWorkflowAnotherFolderCommand command) {
        this.moverAnotherFolder.move(new WorkflowId(command.id()), new WorkflowFolderId(command.folderId()));
        return null;
    }
}
