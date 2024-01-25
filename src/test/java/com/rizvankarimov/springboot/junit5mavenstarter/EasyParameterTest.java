package com.rizvankarimov.springboot.junit5mavenstarter;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.calculator.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EasyParameterTest {

    private final Calculator calculator = new Calculator();
    @ParameterizedTest
    @CsvSource({"10,2,20","20,5,100","30,3,90"})
    public void easyCheckMeters(int width, int heigth, int expected) {
        assertEquals(expected, calculator.checkMeter(width, heigth));
    }

    @ParameterizedTest
    @CsvSource({"5,10,2,100", "2,5,10,100", "3,3,9,81"})
    public void easyCheckCubMeter(int width, int height, int length, int expected) {
        assertEquals(calculator.checkCubMeter(width, height, length), expected);
    }
}
