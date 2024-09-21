package com.autotasks.workflow.shared.domain.value_objects;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class DateTimeValueObject {
    private LocalDateTime value;

    public DateTimeValueObject(LocalDateTime value) {
        this.value = value;
    }

    public DateTimeValueObject() {
        this.value = null;
    }

    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        DateTimeValueObject that = (DateTimeValueObject) object;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
