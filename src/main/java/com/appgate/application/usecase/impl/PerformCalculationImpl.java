package com.appgate.application.usecase.impl;

import com.appgate.application.model.CalculatorStorage;
import com.appgate.application.model.Operation;
import com.appgate.application.usecase.PerformCalculation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class PerformCalculationImpl implements PerformCalculation {

    @Override
    public Number apply(UUID operationId, Operation operation) {
        return CalculatorStorage.operands.get(operationId).stream()
                .map(number -> new BigDecimal(String.valueOf(number)))
                .reduce(operation.getOperationFunction()).get();
    }
}
