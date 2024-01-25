package com.rizvankarimov.springboot.junit5mavenstarter.parameterTest;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.calculator.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterTest {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "10, 2, 20",
            "15, 2, 30",
            "20, 2, 40",
            "25, 2, 50",
            "30, 2, 60",
            "35, 2, 70"
    })

    public void mulTest(int width, int height, int expected) {
        assertEquals(expected, calculator.mul(width, height));
    }
}



