package com.appgate.application.usecase;

import java.util.UUID;

@FunctionalInterface
public interface LoadOperand {

    String apply(UUID operationId, Number number);
}
