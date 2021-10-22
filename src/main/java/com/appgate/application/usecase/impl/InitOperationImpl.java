package com.appgate.application.usecase.impl;

import com.appgate.application.model.CalculatorStorage;
import com.appgate.application.usecase.InitOperation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class InitOperationImpl implements InitOperation {

    @Override
    public void apply(UUID operationId) {
        CalculatorStorage.operands.put(operationId, new ArrayList<>());
    }
}
