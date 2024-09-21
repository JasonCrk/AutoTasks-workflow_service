package com.autotasks.workflow.infrastructure.persistence.jpa.mappers;

import com.autotasks.workflow.domain.entities.Workflow;
import com.autotasks.workflow.domain.value_objects.WorkflowDateCreated;
import com.autotasks.workflow.domain.value_objects.WorkflowFolderId;
import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.domain.value_objects.WorkflowName;
import com.autotasks.workflow.infrastructure.persistence.jpa.models.JpaWorkflow;

import java.util.UUID;

public final class WorkflowMapper {

    public static Workflow modelToEntity(JpaWorkflow model) {
        return new Workflow(
                new WorkflowId(model.getId().toString()),
                new WorkflowName(model.getName()),
                new WorkflowFolderId(model.getFolderId().toString()),
                new WorkflowDateCreated(model.getDateCreated()),
                model.isActive()
        );
    }

    public static JpaWorkflow entityToModel(Workflow workflow) {
        return new JpaWorkflow(
                UUID.fromString(workflow.id().value()),
                workflow.name().value(),
                workflow.isActive(),
                UUID.fromString(workflow.folderId().value()),
                workflow.dateCreated().value()
        );
    }

    public static JpaWorkflow createModel(Workflow workflow) {
        return JpaWorkflow.builder()
                .name(workflow.name().value())
                .isActive(workflow.isActive())
                .folderId(UUID.fromString(workflow.folderId().value()))
                .build();
    }
}
