package com.autotasks.workflow.shared.domain.bus.command;

public interface CommandBus {
    <R> R dispatch(Command command) throws CommandHandlerExecutionError;
}
