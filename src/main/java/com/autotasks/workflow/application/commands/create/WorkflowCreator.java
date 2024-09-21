package com.autotasks.workflow.application.commands.create;

import com.autotasks.workflow.domain.entities.Workflow;
import com.autotasks.workflow.domain.ports.repositories.WorkflowRepository;
import com.autotasks.workflow.domain.value_objects.WorkflowFolderId;
import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.domain.value_objects.WorkflowName;

import com.autotasks.workflow.shared.domain.Service;

@Service
public final class WorkflowCreator {

    private final WorkflowRepository workflowRepository;

    public WorkflowCreator(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public void create(
            WorkflowId id,
            WorkflowName name,
            WorkflowFolderId folderId
    ) {
        this.workflowRepository.save(Workflow.create(id, name, folderId));
    }
}
