package com.autotasks.workflow.shared.domain.bus.query;

public interface QueryBus {
    <R> R ask(Query query) throws QueryHandlerExecutionError;
}
