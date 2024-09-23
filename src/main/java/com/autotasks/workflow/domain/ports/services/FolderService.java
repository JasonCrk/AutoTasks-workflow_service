package com.autotasks.workflow.domain.ports.services;

import com.autotasks.workflow.domain.value_objects.WorkflowId;

public interface FolderService {
    void existsById(WorkflowId id);
}
