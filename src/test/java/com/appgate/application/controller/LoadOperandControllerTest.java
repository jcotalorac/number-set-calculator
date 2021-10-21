package com.appgate.application.controller;

import com.appgate.application.controller.dto.LoadOperandRequest;
import com.appgate.application.controller.dto.LoadOperandResponse;
import com.appgate.application.usecase.LoadOperand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class LoadOperandControllerTest {

    @InjectMocks
    private LoadOperandController loadOperandController;

    @Mock
    private LoadOperand loadOperand;

    @Test
    void testSuccessfulLoadOperand() {
        String expectedSuccessfulResult = "OK";
        when(loadOperand.apply(any(UUID.class), any(Number.class))).thenReturn("OK");

        LoadOperandResponse loadOperandResponse = loadOperandController
                .loadOperand(LoadOperandRequest.builder()
                        .operationId(UUID.randomUUID())
                        .operand(3)
                        .build());

        assertNotNull(loadOperandResponse);
        assertEquals(expectedSuccessfulResult, loadOperandResponse.getResult());
    }
}