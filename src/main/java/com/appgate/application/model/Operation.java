package com.appgate.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

@Getter
@AllArgsConstructor
public enum Operation {
    ADD(BigDecimal::add),
    SUBSTRACT(BigDecimal::subtract),
    MULTIPLY(BigDecimal::multiply),
    DIVIDE(BigDecimal::divide),
    POWER(BigDecimal::max);

    private BinaryOperator<BigDecimal> operationFunction;
}
