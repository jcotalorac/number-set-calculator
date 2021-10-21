package com.appgate.application.usecase.impl;

import com.appgate.application.model.CalculatorStorage;
import com.appgate.application.usecase.PersistOperand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class PersistOperandImpl implements PersistOperand {

    public static final String OK = "OK";
    public static final String KO = "KO";

    @Override
    public String apply(UUID operationId, Number operand) {
        log.info("Persist operand use case");
        log.debug("Operation id: " + operationId + ", operand: " + operand);
        String result = "";
        if (CalculatorStorage.operands.containsKey(operationId)) {
            CalculatorStorage.operands.get(operationId).add(operand);
            result = OK;
            return OK;
        } else {
            result = KO;
        }

        log.debug("Result: " + result);
        return result;
    }
}
