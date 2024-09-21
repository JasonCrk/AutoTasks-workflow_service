package com.autotasks.workflow.application.commands.delete;

import com.autotasks.workflow.domain.ports.repositories.WorkflowRepository;
import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.shared.domain.Service;

@Service
public final class WorkflowEliminator {

    private final WorkflowRepository workflowRepository;

    public WorkflowEliminator(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void delete(WorkflowId id) {
        this.workflowRepository.deleteById(id);
    }
}
