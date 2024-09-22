package com.autotasks.workflow.application.commands.activation_switch;

import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.shared.domain.Service;
import com.autotasks.workflow.shared.domain.bus.command.CommandHandler;

@Service
public final class ActivationSwitchWorkflowCommandHandler implements CommandHandler<ActivationSwitchWorkflowCommand, Void> {

    private final WorkflowActivationSwitcher activationSwitcher;

    public ActivationSwitchWorkflowCommandHandler(WorkflowActivationSwitcher activationSwitcher) {
        this.activationSwitcher = activationSwitcher;
    }

    @Override
    public Void handle(ActivationSwitchWorkflowCommand command) {
        activationSwitcher.switchActivation(new WorkflowId(command.id()));
        return null;
    }
}
