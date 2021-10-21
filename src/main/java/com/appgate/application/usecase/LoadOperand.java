package com.appgate.application.usecase;

@FunctionalInterface
public interface LoadOperand {

    String apply(Number number);
}
