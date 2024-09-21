package com.autotasks.workflow.infrastructure.persistence.jpa.repositories;

import com.autotasks.workflow.infrastructure.persistence.jpa.models.JpaWorkflow;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaWorkflowRepository extends JpaRepository<JpaWorkflow, UUID> {
}
