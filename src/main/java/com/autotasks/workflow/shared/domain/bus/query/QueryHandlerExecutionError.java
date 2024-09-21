package com.autotasks.workflow.shared.domain.bus.query;

public final class QueryHandlerExecutionError extends RuntimeException {
    public QueryHandlerExecutionError(Throwable error) {
        super(error);
    }
}
