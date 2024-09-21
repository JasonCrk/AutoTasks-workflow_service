package com.autotasks.workflow.application.commands.delete;

import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.shared.domain.Service;
import com.autotasks.workflow.shared.domain.bus.command.CommandHandler;

@Service
public final class DeleteWorkflowCommandHandler implements CommandHandler<DeleteWorkflowCommand, Void> {

    private final WorkflowEliminator eliminator;

    public DeleteWorkflowCommandHandler(WorkflowEliminator eliminator) {
        this.eliminator = eliminator;
    }

    @Override
    public Void handle(DeleteWorkflowCommand command) {
        eliminator.delete(new WorkflowId(command.id()));
        return null;
    }
}
