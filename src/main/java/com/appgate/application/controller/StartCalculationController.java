package com.appgate.application.controller;

import com.appgate.application.controller.dto.StartCalculationResponse;
import com.appgate.application.usecase.StartCalculation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StartCalculationController {

    @Autowired
    private StartCalculation startCalculation;

    @Operation(summary = "Initialize operation returning an id")
    @GetMapping("/startCalculation")
    public StartCalculationResponse startCalculation() {
        return StartCalculationResponse.builder()
                .operationId(startCalculation.apply()).build();
    }
}