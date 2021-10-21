package com.appgate.application.controller;

import com.appgate.application.controller.dto.LoadOperandRequest;
import com.appgate.application.controller.dto.LoadOperandResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class LoadOperandControllerTest {

    @InjectMocks
    private LoadOperandController loadOperandController;

    @Test
    void testSuccessfulLoadOperand() {
        String expectedSuccessfulResult = "OK";

        LoadOperandResponse loadOperandResponse = loadOperandController.loadOperand(LoadOperandRequest.builder().build());

        assertNotNull(loadOperandResponse);
        assertEquals(expectedSuccessfulResult, loadOperandResponse.getResult());
    }
}