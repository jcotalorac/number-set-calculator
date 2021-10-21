package com.appgate.application.usecase;

import com.appgate.application.usecase.impl.PersistOperandImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
        persistOperand.apply(8);
    }
}