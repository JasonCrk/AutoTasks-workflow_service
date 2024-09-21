package com.autotasks.workflow.domain.value_objects;

import com.autotasks.workflow.shared.domain.value_objects.DateTimeValueObject;

import java.time.LocalDateTime;

public final class WorkflowDateCreated extends DateTimeValueObject {

    public WorkflowDateCreated(LocalDateTime value) {
        super(value);
    }

    public WorkflowDateCreated() {}
}
