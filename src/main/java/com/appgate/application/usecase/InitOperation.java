package com.appgate.application.usecase;

import java.util.UUID;

@FunctionalInterface
public interface InitOperation {

    void apply(UUID operationId);
}
