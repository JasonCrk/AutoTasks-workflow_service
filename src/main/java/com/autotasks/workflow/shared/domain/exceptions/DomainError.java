package com.autotasks.workflow.shared.domain.exceptions;

public class DomainError extends RuntimeException {
    private final String errorMessage;
    private final String errorCode;

    public DomainError(String errorCode, String errorMessage) {
        super(errorMessage);

        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }
}
