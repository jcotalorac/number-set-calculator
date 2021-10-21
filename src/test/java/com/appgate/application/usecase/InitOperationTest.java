package com.appgate.application.usecase;

import com.appgate.application.usecase.impl.InitOperationImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InitOperationTest {


    private InitOperation initOperation;

    @InjectMocks
    private InitOperationImpl initOperationImpl;

    @BeforeAll
    void setUp() {
        initOperation = initOperationImpl;
    }

    @Test
    void testSuccessfulApply() {
        String stringUUID = "230bd0ab-d2f6-415c-b5ff-9997555175a6";
        UUID convertedUUID = UUID.fromString(stringUUID);

        initOperation.apply(convertedUUID);
    }
}