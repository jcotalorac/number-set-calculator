package com.appgate.application.usecase.impl;

import com.appgate.application.model.CalculatorStorage;
import com.appgate.application.usecase.PersistOperand;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersistOperandImpl implements PersistOperand {

    @Override
    public String apply(UUID operationId, Number operand) {
        if (CalculatorStorage.operands.containsKey(operationId)) {
            CalculatorStorage.operands.get(operationId).add(operand);
            return "OK";
        } else {
            return "KO";
        }
    }
}
