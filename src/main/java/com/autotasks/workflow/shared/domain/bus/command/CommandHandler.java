package com.autotasks.workflow.shared.domain.bus.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
