package com.appgate.application.usecase;

import com.appgate.application.model.Operation;

import java.util.UUID;

@FunctionalInterface
public interface PerformCalculation {

    Number apply(UUID operationId, Operation operation);
}
