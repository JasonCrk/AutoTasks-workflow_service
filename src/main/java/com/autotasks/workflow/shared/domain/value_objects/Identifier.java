package com.autotasks.workflow.shared.domain.value_objects;

import java.io.Serializable;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier implements Serializable {
    private final String value;

    public Identifier(String value) {
        ensureIsValid(value);
        this.value = value;
    }

    public Identifier() {
        this.value = null;
    }

    public String value() {
        return value;
    }

    public void ensureIsValid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        Identifier that = (Identifier) object;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
