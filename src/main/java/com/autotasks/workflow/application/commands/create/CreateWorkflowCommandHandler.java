package com.autotasks.workflow.application.commands.create;

import com.autotasks.workflow.domain.value_objects.WorkflowFolderId;
import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.domain.value_objects.WorkflowName;

import com.autotasks.workflow.shared.domain.Service;
import com.autotasks.workflow.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateWorkflowCommandHandler implements CommandHandler<CreateWorkflowCommand, Void> {

    private final WorkflowCreator creator;

    public CreateWorkflowCommandHandler(WorkflowCreator creator) {
        this.creator = creator;
    }

    @Override
    public Void handle(CreateWorkflowCommand command) {
        creator.create(
                new WorkflowId(command.id()),
                new WorkflowName(command.name()),
                new WorkflowFolderId(command.folderId())
        );

        return null;
    }
}
