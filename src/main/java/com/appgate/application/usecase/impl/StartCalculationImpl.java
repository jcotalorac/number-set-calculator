package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.StartCalculation;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StartCalculationImpl implements StartCalculation {

    @Override
    public UUID apply() {
        return UUID.randomUUID();
    }
}
