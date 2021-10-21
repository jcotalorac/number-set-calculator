package com.appgate.application.usecase;

@FunctionalInterface
public interface PersistOperand {

    void apply(Number operand);
}
