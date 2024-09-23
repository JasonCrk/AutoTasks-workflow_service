package com.autotasks.workflow.application.commands.move_another_folder;

import com.autotasks.workflow.domain.entities.Workflow;
import com.autotasks.workflow.domain.ports.repositories.WorkflowRepository;
import com.autotasks.workflow.domain.ports.services.FolderService;
import com.autotasks.workflow.domain.value_objects.WorkflowFolderId;
import com.autotasks.workflow.domain.value_objects.WorkflowId;

import com.autotasks.workflow.shared.domain.Service;

import feign.FeignException;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public final class WorkflowMoverAnotherFolder {

    private final WorkflowRepository workflowRepository;

    private final FolderService folderService;

    public WorkflowMoverAnotherFolder(
            WorkflowRepository workflowRepository,
            FolderService folderService
    ) {
        this.workflowRepository = workflowRepository;
        this.folderService = folderService;
    }

    public void move(WorkflowId id, WorkflowFolderId folderId) {
        Workflow workflow = this.workflowRepository.findById(id)
                .orElseThrow();

        if (workflow.folderId().equals(folderId)) return;

        try {
            this.folderService.existsById(workflow.id());
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The folder does not exist");
        }

        workflow.updateFolderId(folderId);

        this.workflowRepository.save(workflow);
    }
}
