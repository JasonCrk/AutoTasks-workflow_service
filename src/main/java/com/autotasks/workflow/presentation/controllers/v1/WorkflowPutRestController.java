package com.autotasks.workflow.presentation.controllers.v1;

import com.autotasks.workflow.application.commands.create.CreateWorkflowCommand;
import com.autotasks.workflow.presentation.requests.CreateWorkflowRequest;

import com.autotasks.workflow.shared.domain.bus.command.CommandBus;
import com.autotasks.workflow.shared.domain.bus.command.CommandHandlerExecutionError;
import com.autotasks.workflow.shared.domain.bus.query.QueryBus;
import com.autotasks.workflow.shared.domain.exceptions.DomainError;
import com.autotasks.workflow.shared.infrastructure.controllers.RestApiController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@Tag(name = "PUTs")
@RestController
@RequestMapping("/api/v1/workflows")
public class WorkflowPutRestController extends RestApiController {

    public WorkflowPutRestController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @Operation(operationId = "Create a workflow")
    @PutMapping("/{id}")
    public ResponseEntity<String> create(
            @PathVariable("id") UUID id,
            @Valid @RequestBody CreateWorkflowRequest body
    ) throws CommandHandlerExecutionError {
        this.dispatch(new CreateWorkflowCommand(id.toString(), body.name(), body.folderId().toString()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
