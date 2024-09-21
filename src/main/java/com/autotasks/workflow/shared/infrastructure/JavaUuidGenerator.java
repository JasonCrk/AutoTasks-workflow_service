package com.autotasks.workflow.shared.infrastructure;

import com.autotasks.workflow.shared.domain.Service;
import com.autotasks.workflow.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {

    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
