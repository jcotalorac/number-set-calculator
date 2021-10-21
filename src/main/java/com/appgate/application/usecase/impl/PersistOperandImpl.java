package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.PersistOperand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersistOperandImpl implements PersistOperand {

    public static List<Number> operands = new ArrayList<>();

    @Override
    public void apply(Number operand) {
        operands.add(operand);
    }
}
