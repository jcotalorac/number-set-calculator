package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.LoadOperand;
import com.appgate.application.usecase.PersistOperand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class LoadOperandImpl implements LoadOperand {

    @Autowired
    private PersistOperand persistOperand;

    @Override
    public String apply(UUID operationId, Number operand) {
        log.info("Loading operand use case");
        log.debug("Operation id: " + operationId + ", operand: " + operand);
        return persistOperand.apply(operationId, operand);
    }
}
