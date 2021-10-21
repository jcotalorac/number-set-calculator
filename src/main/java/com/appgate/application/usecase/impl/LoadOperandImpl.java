package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.LoadOperand;
import com.appgate.application.usecase.PersistOperand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoadOperandImpl implements LoadOperand {

    @Autowired
    private PersistOperand persistOperand;

    @Override
    public String apply(UUID operationId, Number number) {
        persistOperand.apply(operationId, number);
        return "OK";
    }
}
