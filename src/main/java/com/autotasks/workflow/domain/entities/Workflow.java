package com.autotasks.workflow.domain.entities;

import com.autotasks.workflow.domain.value_objects.WorkflowFolderId;
import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.domain.value_objects.WorkflowName;

public class Workflow {
    private final WorkflowId id;
    private final WorkflowName name;
    private final WorkflowFolderId folderId;
    private final boolean isActive;

    public Workflow(WorkflowId id, WorkflowName name, WorkflowFolderId folderId, boolean isActive) {
        this.id = id;
        this.name = name;
        this.folderId = folderId;
        this.isActive = isActive;
    }

    public Workflow() {
        this.id = null;
        this.name = null;
        this.folderId = null;
        this.isActive = false;
    }

    public static Workflow create(WorkflowId id, WorkflowName name, WorkflowFolderId folderId, boolean isActive) {
        Workflow workflow = new Workflow(id, name, folderId, isActive);
        return workflow;
    }

    public WorkflowId getId() {
        return id;
    }

    public WorkflowName getName() {
        return name;
    }

    public WorkflowFolderId getFolderId() {
        return folderId;
    }

    public boolean isActive() {
        return isActive;
    }
}
