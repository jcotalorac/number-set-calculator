package com.appgate.application.usecase;

import com.appgate.application.usecase.impl.StartCalculationImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StartCalculationTest {

    private StartCalculation startCalculation;

    @InjectMocks
    private StartCalculationImpl startCalculationImpl;

    @Mock
    private InitOperation initOperation;

    @BeforeAll
    void setUp() {
        startCalculation = startCalculationImpl;
    }

    @Test
    void testSuccessfulApply() {
        UUID uuid = startCalculation.apply();

        assertNotNull(uuid);
    }
}