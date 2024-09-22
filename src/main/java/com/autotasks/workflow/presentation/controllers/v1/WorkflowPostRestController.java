package com.autotasks.workflow.presentation.controllers.v1;

import com.autotasks.workflow.application.commands.activation_switch.ActivationSwitchWorkflowCommand;
import com.autotasks.workflow.shared.domain.bus.command.CommandBus;
import com.autotasks.workflow.shared.domain.bus.query.QueryBus;
import com.autotasks.workflow.shared.domain.exceptions.DomainError;
import com.autotasks.workflow.shared.infrastructure.controllers.RestApiController;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@Tag(name = "POSTs")
@RestController
@RequestMapping("/api/v1/workflows")
public class WorkflowPostRestController extends RestApiController {

    public WorkflowPostRestController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/{id}/activation")
    public ResponseEntity<String> activationSwitch(@PathVariable("id") UUID id) {
        this.dispatch(new ActivationSwitchWorkflowCommand(id.toString()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
