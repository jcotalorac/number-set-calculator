package com.appgate.application.controller;

import com.appgate.application.controller.dto.PerformCalculationRequest;
import com.appgate.application.controller.dto.PerformCalculationResponse;
import com.appgate.application.model.Operation;
import com.appgate.application.usecase.PerformCalculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PerformCalculationControllerTest {

    @InjectMocks
    private PerformCalculationController performCalculationController;

    @Mock
    private PerformCalculation performCalculation;

    @Test
    void testSuccessfulPerformCalculation() {
        String stringUUID = "230bd0ab-d2f6-415c-b5ff-9997555175a6";
        UUID convertedUUID = UUID.fromString(stringUUID);

        when(performCalculation.apply(any(UUID.class), any(Operation.class))).thenReturn(5);

        PerformCalculationResponse performCalculationResponse = performCalculationController
                .performCalculation(PerformCalculationRequest.builder()
                        .operationId(convertedUUID)
                        .operation("ADD")
                        .build());

        assertNotNull(performCalculationResponse);
        assertNotNull(performCalculationResponse.getResult());
        assertEquals(5, performCalculationResponse.getResult());
    }
}