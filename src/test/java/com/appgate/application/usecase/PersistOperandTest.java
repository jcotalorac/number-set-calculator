package com.appgate.application.usecase;

import com.appgate.application.model.CalculatorStorage;
import com.appgate.application.usecase.impl.PersistOperandImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersistOperandTest {

    private PersistOperand persistOperand;

    @InjectMocks
    private PersistOperandImpl persistOperandImpl;

    @BeforeAll
    void setUp() {
        persistOperand = persistOperandImpl;
    }
    @Test
    void testSuccessfulApply() {
        String stringUUID = "230bd0ab-d2f6-415c-b5ff-9997555175a6";
        UUID convertedUUID = UUID.fromString(stringUUID);

        CalculatorStorage.operands.put(convertedUUID, new ArrayList<>());

        String result = persistOperand.apply(convertedUUID, 8);

        assertEquals("OK", result);
    }
}