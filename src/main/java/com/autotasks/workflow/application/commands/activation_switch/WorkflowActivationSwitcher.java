package com.autotasks.workflow.application.commands.activation_switch;

import com.autotasks.workflow.domain.entities.Workflow;
import com.autotasks.workflow.domain.ports.repositories.WorkflowRepository;
import com.autotasks.workflow.domain.value_objects.WorkflowId;

import com.autotasks.workflow.shared.domain.Service;

@Service
public final class WorkflowActivationSwitcher {

    private final WorkflowRepository workflowRepository;

    public WorkflowActivationSwitcher(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void switchActivation(WorkflowId id) {
        Workflow workflow = workflowRepository.findById(id)
                .orElseThrow();

        workflow.updateIsActive(!workflow.isActive());

        this.workflowRepository.save(workflow);
    }
}
