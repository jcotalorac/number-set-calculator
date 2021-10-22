package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.InitOperation;
import com.appgate.application.usecase.StartCalculation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class StartCalculationImpl implements StartCalculation {

    @Autowired
    private InitOperation initOperation;

    @Override
    public UUID apply() {
        log.info("Start calculation use case");
        UUID uuid = UUID.randomUUID();
        initOperation.apply(uuid);
        log.debug("Returning operation id: " + uuid);
        return uuid;
    }
}
