package com.appgate.application.controller;

import com.appgate.application.controller.dto.LoadOperandRequest;
import com.appgate.application.controller.dto.LoadOperandResponse;
import com.appgate.application.usecase.LoadOperand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadOperandController {

    @Autowired
    private LoadOperand loadOperand;

    @PostMapping("/loadOperand")
    public LoadOperandResponse loadOperand(LoadOperandRequest loadOperandRequest) {
        return LoadOperandResponse.builder()
                .result(loadOperand.apply(loadOperandRequest.getOperationId(), loadOperandRequest.getOperand()))
                .build();
    }
}
