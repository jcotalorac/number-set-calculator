package com.appgate.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class NumberSetCalculatorApplication {

    public static void main(String[] args) {
        log.debug("Initializing number set calculator");
        SpringApplication.run(NumberSetCalculatorApplication.class, args);
    }
}
