package com.appgate.application.controller;

import com.appgate.application.controller.dto.PerformCalculationRequest;
import com.appgate.application.controller.dto.PerformCalculationResponse;
import com.appgate.application.model.Operation;
import com.appgate.application.usecase.PerformCalculation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PerformCalculationController {

    @Autowired
    private PerformCalculation performCalculation;

    @PostMapping("/performOperation")
    public PerformCalculationResponse performCalculation(@RequestBody PerformCalculationRequest performCalculationRequest) {
        log.info("Performing operation");
        log.debug("Performing operation request: " + performCalculationRequest);
        return PerformCalculationResponse.builder()
                .result(performCalculation.apply(performCalculationRequest.getOperationId(),
                        Operation.valueOf(performCalculationRequest.getOperation())))
                .build();
    }
}
