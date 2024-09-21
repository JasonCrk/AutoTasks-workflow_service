package com.autotasks.workflow.infrastructure.persistence.jpa.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workflows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JpaWorkflow {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @Column(name = "is_active", columnDefinition = "BOOLEAN", nullable = false)
    private boolean isActive;

    @Column(name = "folder_id", nullable = false)
    private UUID folderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "date_created",
            columnDefinition = "TIMESTAMP DEFAULT NOW()",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private LocalDateTime dateCreated;
}
