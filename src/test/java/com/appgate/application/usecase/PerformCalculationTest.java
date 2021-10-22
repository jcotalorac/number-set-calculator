package com.appgate.application.usecase;

import com.appgate.application.model.CalculatorStorage;
import com.appgate.application.model.Operation;
import com.appgate.application.usecase.impl.PerformCalculationImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PerformCalculationTest {

    private PerformCalculation performCalculation;

    @InjectMocks
    private PerformCalculationImpl performCalculationImpl;

    private String stringUUID = "230bd0ab-d2f6-415c-b5ff-9997555175a6";
    private UUID convertedUUID = UUID.fromString(stringUUID);

    @BeforeAll
    void setUp() {
        performCalculation = performCalculationImpl;

        CalculatorStorage.operands.put(convertedUUID, List.of(1, 2));
    }

    @ParameterizedTest
    @EnumSource(Operation.class)
    void testSuccessfulApply(Operation operation) {

        Number result = performCalculation.apply(convertedUUID, operation);

        assertNotNull(result);
    }
}