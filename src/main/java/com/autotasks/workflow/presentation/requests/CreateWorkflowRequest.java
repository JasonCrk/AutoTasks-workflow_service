package com.autotasks.workflow.presentation.requests;

import java.util.UUID;

public record CreateWorkflowRequest(
        String name,
        UUID folderId
) {
}
