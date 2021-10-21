package com.appgate.application.controller;

import com.appgate.application.controller.dto.LoadOperandRequest;
import com.appgate.application.controller.dto.LoadOperandResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadOperandController {

    @PostMapping("/loadOperand")
    public LoadOperandResponse loadOperand(LoadOperandRequest operand) {
        return LoadOperandResponse.builder().result("OK").build();
    }
}
