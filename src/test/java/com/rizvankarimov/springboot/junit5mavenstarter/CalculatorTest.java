package com.rizvankarimov.springboot.junit5mavenstarter;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void addTest() {
        // GIVEN
        var calculator = new Calculator();
        int count1 = 5;
        int count2 = 10;

        // WHEN
        int resultAdd = calculator.add(count1, count2);

        // THEN
        assertEquals(15, resultAdd);
    }

    @Test
    public void subTest(){
        // GIVEN
        var calculator = new Calculator();
        int count1 = 10;
        int count2 = 5;

        // WHEN
        int resultSub = calculator.sub(count1, count2);

        // THEN
        assertEquals(5, resultSub);

    }

    @Test
    public void mulTest(){
        var mulCalculator = new Calculator();
        int count1 = 5;
        int count2 = 10;
        int resultMul = mulCalculator.mul(count1, count2);
        assertEquals(50,resultMul);
    }
}
