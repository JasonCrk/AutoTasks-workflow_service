package com.autotasks.workflow.domain.entities;

import com.autotasks.workflow.domain.value_objects.WorkflowDateCreated;
import com.autotasks.workflow.domain.value_objects.WorkflowFolderId;
import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.domain.value_objects.WorkflowName;

public class Workflow {
    private final WorkflowId id;
    private final WorkflowName name;
    private final WorkflowFolderId folderId;
    private final WorkflowDateCreated dateCreated;
    private boolean isActive;

    public Workflow(
            WorkflowId id,
            WorkflowName name,
            WorkflowFolderId folderId,
            WorkflowDateCreated dateCreated,
            boolean isActive
    ) {
        this.id = id;
        this.name = name;
        this.folderId = folderId;
        this.dateCreated = dateCreated;
        this.isActive = isActive;
    }

    public Workflow() {
        this.id = null;
        this.name = null;
        this.folderId = null;
        this.dateCreated = null;
        this.isActive = false;
    }

    public static Workflow create(
            WorkflowId id,
            WorkflowName name, WorkflowFolderId folderId) {
        Workflow workflow = new Workflow(id, name, folderId, new WorkflowDateCreated(), true);
        return workflow;
    }

    public WorkflowId id() {
        return id;
    }

    public WorkflowName name() {
        return name;
    }

    public WorkflowFolderId folderId() {
        return folderId;
    }

    public WorkflowDateCreated dateCreated() {
        return dateCreated;
    }

    public boolean isActive() {
        return isActive;
    }

    public void updateIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
