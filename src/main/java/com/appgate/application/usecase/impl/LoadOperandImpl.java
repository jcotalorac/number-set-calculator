package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.LoadOperand;
import com.appgate.application.usecase.PersistOperand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadOperandImpl implements LoadOperand {

    @Autowired
    private PersistOperand persistOperand;

    @Override
    public String apply(Number number) {
        persistOperand.apply(number);
        return "OK";
    }
}
