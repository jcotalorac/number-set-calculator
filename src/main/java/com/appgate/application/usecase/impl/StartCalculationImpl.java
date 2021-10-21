package com.appgate.application.usecase.impl;

import com.appgate.application.usecase.StartCalculation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class StartCalculationImpl implements StartCalculation {

    @Override
    public UUID apply() {
        log.info("Start calculation use case");
        UUID uuid = UUID.randomUUID();
        log.debug("Returning operation id: " + uuid);
        return uuid;
    }
}
