package com.appgate.application;

import com.appgate.application.controller.dto.LoadOperandRequest;
import com.appgate.application.controller.dto.PerformCalculationRequest;
import com.appgate.application.controller.dto.StartCalculationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void given2OperandWhenAddThemThenResultIsOK() throws Exception {

        int firstOperand = 1;
        int secondOperand = 2;
        int expectedValue = 3;

        mockMvc.perform(get("/startCalculation")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(startCalculationResult -> mockMvc.perform(post("/loadOperand")
                                .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                        StartCalculationResponse.class).getOperationId())
                                        .operand(firstOperand)
                                .build())))
                        .andDo(print())
                        .andDo(loadOperandResult1 -> {
                            mockMvc.perform(post("/loadOperand")
                                            .contentType(MediaType.APPLICATION_JSON)
                                    .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                                    .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                            StartCalculationResponse.class).getOperationId())
                                                    .operand(secondOperand)
                                            .build())))
                                    .andDo(print())
                                    .andDo(result -> mockMvc.perform(post("/performOperation")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                            .content(mapper.writeValueAsString(PerformCalculationRequest.builder()
                                                            .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                                    StartCalculationResponse.class).getOperationId())
                                                            .operation("ADD")
                                                    .build())))
                                            .andDo(print())
                                            .andExpect(status().isOk())
                                            .andExpect(jsonPath("$.result").value(expectedValue)));
                        }));
    }

    @Test
    void given2OperandWhenSubstractThemThenResultIsOK() throws Exception {

        int firstOperand = 1;
        int secondOperand = 2;
        int expectedValue = -1;

        mockMvc.perform(get("/startCalculation")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(startCalculationResult -> mockMvc.perform(post("/loadOperand")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                        .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                StartCalculationResponse.class).getOperationId())
                                        .operand(firstOperand)
                                        .build())))
                        .andDo(print())
                        .andDo(loadOperandResult1 -> {
                            mockMvc.perform(post("/loadOperand")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                                    .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                            StartCalculationResponse.class).getOperationId())
                                                    .operand(secondOperand)
                                                    .build())))
                                    .andDo(print())
                                    .andDo(result -> mockMvc.perform(post("/performOperation")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(mapper.writeValueAsString(PerformCalculationRequest.builder()
                                                            .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                                    StartCalculationResponse.class).getOperationId())
                                                            .operation("SUBSTRACT")
                                                            .build())))
                                            .andDo(print())
                                            .andExpect(status().isOk())
                                            .andExpect(jsonPath("$.result").value(expectedValue)));
                        }));
    }

    @Test
    void given2OperandWhenMultiplyThemThenResultIsOK() throws Exception {

        int firstOperand = 1;
        int secondOperand = 2;
        int expectedValue = 2;

        mockMvc.perform(get("/startCalculation")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(startCalculationResult -> mockMvc.perform(post("/loadOperand")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                        .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                StartCalculationResponse.class).getOperationId())
                                        .operand(firstOperand)
                                        .build())))
                        .andDo(print())
                        .andDo(loadOperandResult1 -> {
                            mockMvc.perform(post("/loadOperand")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                                    .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                            StartCalculationResponse.class).getOperationId())
                                                    .operand(secondOperand)
                                                    .build())))
                                    .andDo(print())
                                    .andDo(result -> mockMvc.perform(post("/performOperation")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(mapper.writeValueAsString(PerformCalculationRequest.builder()
                                                            .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                                    StartCalculationResponse.class).getOperationId())
                                                            .operation("MULTIPLY")
                                                            .build())))
                                            .andDo(print())
                                            .andExpect(status().isOk())
                                            .andExpect(jsonPath("$.result").value(expectedValue)));
                        }));
    }

    @Test
    void given2OperandWhenDivideThemThenResultIsOK() throws Exception {

        int firstOperand = 1;
        int secondOperand = 2;
        double expectedValue = 0.5;

        mockMvc.perform(get("/startCalculation")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(startCalculationResult -> mockMvc.perform(post("/loadOperand")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                        .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                StartCalculationResponse.class).getOperationId())
                                        .operand(firstOperand)
                                        .build())))
                        .andDo(print())
                        .andDo(loadOperandResult1 -> {
                            mockMvc.perform(post("/loadOperand")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                                    .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                            StartCalculationResponse.class).getOperationId())
                                                    .operand(secondOperand)
                                                    .build())))
                                    .andDo(print())
                                    .andDo(result -> mockMvc.perform(post("/performOperation")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(mapper.writeValueAsString(PerformCalculationRequest.builder()
                                                            .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                                    StartCalculationResponse.class).getOperationId())
                                                            .operation("DIVIDE")
                                                            .build())))
                                            .andDo(print())
                                            .andExpect(status().isOk())
                                            .andExpect(jsonPath("$.result").value(expectedValue)));
                        }));
    }

    @Test
    void given2OperandWhenPowerThemThenResultIsOK() throws Exception {

        int firstOperand = 1;
        int secondOperand = 2;
        int expectedValue = 2;

        mockMvc.perform(get("/startCalculation")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(startCalculationResult -> mockMvc.perform(post("/loadOperand")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                        .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                StartCalculationResponse.class).getOperationId())
                                        .operand(firstOperand)
                                        .build())))
                        .andDo(print())
                        .andDo(loadOperandResult1 -> {
                            mockMvc.perform(post("/loadOperand")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(mapper.writeValueAsString(LoadOperandRequest.builder()
                                                    .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                            StartCalculationResponse.class).getOperationId())
                                                    .operand(secondOperand)
                                                    .build())))
                                    .andDo(print())
                                    .andDo(result -> mockMvc.perform(post("/performOperation")
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(mapper.writeValueAsString(PerformCalculationRequest.builder()
                                                            .operationId(mapper.readValue(startCalculationResult.getResponse().getContentAsString(),
                                                                    StartCalculationResponse.class).getOperationId())
                                                            .operation("POWER")
                                                            .build())))
                                            .andDo(print())
                                            .andExpect(status().isOk())
                                            .andExpect(jsonPath("$.result").value(expectedValue)));
                        }));
    }
}
