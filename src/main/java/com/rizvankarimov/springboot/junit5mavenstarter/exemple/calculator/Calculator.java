package com.rizvankarimov.springboot.junit5mavenstarter.exemple.calculator;

public class Calculator {
    public int add(int count1, int count2){
        return count1 + count2;
    }

    public int sub(int count1, int count2){
        return count1-count2;
    }

    public int mul(int count1, int count2) {
        return count1*count2;
    }

    public int checkMeter(int width, int length){
        return width*length;
    }

    public int checkCubMeter(int width, int heigth, int length){
        return width*heigth*length;
    }
}
