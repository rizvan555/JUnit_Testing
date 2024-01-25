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
        int resultAdd = calculator.add(count1, count2);

        //Nəticələrin yoxlanması
        assertEquals(15, resultAdd);
    }

    @Test
    public void subTest(){
        //Ön teyinatlar
        var calculator = new Calculator();
        int count1 = 10;
        int count2 = 5;

        //Əməliyyat
        int resultSub = calculator.sub(count1, count2);

        //Nəticələrin yoxlanması
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
