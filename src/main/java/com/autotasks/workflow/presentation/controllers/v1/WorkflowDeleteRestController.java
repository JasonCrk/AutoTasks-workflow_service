package com.autotasks.workflow.presentation.controllers.v1;

import com.autotasks.workflow.application.commands.delete.DeleteWorkflowCommand;

import com.autotasks.workflow.shared.domain.bus.command.CommandBus;
import com.autotasks.workflow.shared.domain.bus.command.CommandHandlerExecutionError;
import com.autotasks.workflow.shared.domain.bus.query.QueryBus;
import com.autotasks.workflow.shared.domain.exceptions.DomainError;
import com.autotasks.workflow.shared.infrastructure.controllers.RestApiController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@Tag(name = "DELETEs")
@RestController
@RequestMapping("/api/v1/workflows")
public class WorkflowDeleteRestController extends RestApiController {

    public WorkflowDeleteRestController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @Operation(operationId = "Delete a workflow")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) throws CommandHandlerExecutionError {
        this.dispatch(new DeleteWorkflowCommand(id.toString()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
