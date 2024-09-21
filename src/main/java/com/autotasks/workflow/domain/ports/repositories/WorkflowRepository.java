package com.autotasks.workflow.domain.ports.repositories;

import com.autotasks.workflow.domain.entities.Workflow;
import com.autotasks.workflow.domain.value_objects.WorkflowId;

public interface WorkflowRepository {
    Workflow save(Workflow workflow);
    void deleteById(WorkflowId id);
}
