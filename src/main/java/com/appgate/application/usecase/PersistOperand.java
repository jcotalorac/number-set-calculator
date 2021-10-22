package com.appgate.application.usecase;

import java.util.UUID;

@FunctionalInterface
public interface PersistOperand {

    String apply(UUID operationId, Number operand);
}
