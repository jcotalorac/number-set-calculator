package com.appgate.application.controller;

import com.appgate.application.controller.dto.StartCalculationResponse;
import com.appgate.application.usecase.StartCalculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class StartCalculationControllerTest {

    @InjectMocks
    private StartCalculationController startCalculationController;

    @Mock
    private StartCalculation startCalculation;

    @Test
    void testSuccessfulStartCalculation() {
        when(startCalculation.apply()).thenReturn(UUID.randomUUID());

        StartCalculationResponse startCalculationResponse = startCalculationController.startCalculation();

        assertNotNull(startCalculationResponse);
        assertNotNull(startCalculationResponse.getOperationId());
    }
}