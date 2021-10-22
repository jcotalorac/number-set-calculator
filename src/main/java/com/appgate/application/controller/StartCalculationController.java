package com.appgate.application.controller;

import com.appgate.application.controller.dto.StartCalculationResponse;
import com.appgate.application.usecase.StartCalculation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StartCalculationController {

    @Autowired
    private StartCalculation startCalculation;

    @Operation(summary = "Initialize operation returning an id")
    @GetMapping("/startCalculation")
    public StartCalculationResponse startCalculation() {
        log.info("Starting calculation");
        return StartCalculationResponse.builder()
                .operationId(startCalculation.apply()).build();
    }
}
