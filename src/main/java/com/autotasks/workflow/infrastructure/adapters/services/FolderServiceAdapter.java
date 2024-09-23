package com.autotasks.workflow.infrastructure.adapters.services;

import com.autotasks.workflow.domain.ports.services.FolderService;

import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.infrastructure.services.FolderServiceClient;
import com.autotasks.workflow.shared.domain.Service;

import java.util.UUID;

@Service
public final class FolderServiceAdapter implements FolderService {

    private final FolderServiceClient serviceClient;

    public FolderServiceAdapter(FolderServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @Override
    public void existsById(WorkflowId id) {
        this.serviceClient.existsById(UUID.fromString(id.value()));
    }
}
