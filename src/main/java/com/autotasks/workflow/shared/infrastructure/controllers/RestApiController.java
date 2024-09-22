package com.autotasks.workflow.shared.infrastructure.controllers;

import com.autotasks.workflow.shared.domain.bus.command.Command;
import com.autotasks.workflow.shared.domain.bus.command.CommandBus;
import com.autotasks.workflow.shared.domain.bus.command.CommandHandlerExecutionError;
import com.autotasks.workflow.shared.domain.bus.query.Query;
import com.autotasks.workflow.shared.domain.bus.query.QueryBus;
import com.autotasks.workflow.shared.domain.bus.query.QueryHandlerExecutionError;
import com.autotasks.workflow.shared.domain.exceptions.DomainError;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public abstract class RestApiController {
    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public RestApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    protected <R> R dispatch(Command command) throws CommandHandlerExecutionError {
        return commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
