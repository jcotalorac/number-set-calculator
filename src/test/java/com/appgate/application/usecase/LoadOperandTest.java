package com.appgate.application.usecase;

import com.appgate.application.usecase.impl.LoadOperandImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LoadOperandTest {

    private LoadOperand loadOperand;

    @InjectMocks
    private LoadOperandImpl loadOperandImpl;

    @Mock
    private PersistOperand persistOperand;

    @BeforeAll
    void setUp() {
        loadOperand = loadOperandImpl;
    }

    @Test
    void testSuccessfulApply() {
        String expected = "OK";
        String stringUUID = "230bd0ab-d2f6-415c-b5ff-9997555175a6";
        UUID convertedUUID = UUID.fromString(stringUUID);

        String result = loadOperand.apply(convertedUUID, 5);

        assertEquals(expected, result);
    }
}