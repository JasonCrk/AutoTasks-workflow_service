package com.autotasks.workflow.infrastructure.adapters.repositories;

import com.autotasks.workflow.domain.entities.Workflow;
import com.autotasks.workflow.domain.ports.repositories.WorkflowRepository;
import com.autotasks.workflow.domain.value_objects.WorkflowId;
import com.autotasks.workflow.infrastructure.persistence.jpa.mappers.WorkflowMapper;
import com.autotasks.workflow.infrastructure.persistence.jpa.models.JpaWorkflow;
import com.autotasks.workflow.infrastructure.persistence.jpa.repositories.JpaWorkflowRepository;

import com.autotasks.workflow.shared.domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional("autotasks_workflow_service-transaction_manager")
public class WorkflowRepositoryAdapter implements WorkflowRepository {

    @Autowired
    private JpaWorkflowRepository repository;

    @Override
    public Workflow save(Workflow workflow) {
        JpaWorkflow workflowSaved = this.repository.save(WorkflowMapper.createModel(workflow));
        return WorkflowMapper.modelToEntity(workflowSaved);
    }

    @Override
    public void deleteById(WorkflowId id) {
        this.repository.deleteById(UUID.fromString(id.value()));
    }

    @Override
    public Optional<Workflow> findById(WorkflowId id) {
        return this.repository.findById(UUID.fromString(id.value())).map(WorkflowMapper::modelToEntity);
    }
}
