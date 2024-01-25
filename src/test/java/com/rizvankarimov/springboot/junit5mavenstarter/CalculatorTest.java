package com.rizvankarimov.springboot.junit5mavenstarter;

import com.rizvankarimov.springboot.junit5mavenstarter.exemple.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void addTest() {

        //Ön təyinatlar
        var calculator = new Calculator();
        int count1 = 5;
        int count2 = 10;

        //Əməliyyat
        int result = calculator.add(count1, count2);

        //Nəticələrin yoxlanması
        assertEquals(15, result);
    }
}
