package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.LoadOperand;
import org.springframework.stereotype.Service;

@Service
public class LoadOperandImpl implements LoadOperand {

    @Override
    public String apply(Number number) {
        return "OK";
    }
}
