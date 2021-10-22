package com.appgate.application.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class CalculatorStorage {

    public static Map<UUID, List<Number>> operands = new HashMap<>();
}
