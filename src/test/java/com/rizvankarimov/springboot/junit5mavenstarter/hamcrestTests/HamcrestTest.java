package com.rizvankarimov.springboot.junit5mavenstarter.hamcrestTests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HamcrestTest {
    @Test
    void BasicEquals() {
        String text1 = "Salam";
        String text2 = "Hallo";

        assertEquals(text1, "Salam");                                                                            // JUNit yolu ile bele yazilir
        assertThat(text2, is(equalTo("Hallo")));                                                                // Hamcrest yolu ile bele yazilir

        //assertThat(text1, is(nullValue()));                                                                           // Yoxlayiriq ki, "text1 = 0"-dirmi?
        assertThat(text1, is(notNullValue()));                                                                          // Yoxlayiriq ki, "text1 = 0"-deyilmi?

        assertThat(text1, containsString("m"));                                                                // Yoxlayiriq ki, "text1-in icinde "m" herfi varmi?
        if(text2.contains("S")){                                                                                        // Yoxlayiriq ki, "text1-in icinde "S" herfi varsa "S herfi var" yaz, yosdursa "S herfi yoxdur"yaz  ?
            System.out.println("S herfi var");
        }else {
            System.out.println("S herfi yoxdur");
        }

        assertThat(text1, anyOf(containsString("m"), containsString("l")));                            // Yoxlayiriq ki, "text1-in icinde "m" ve yoxsa "l" herfi varmi?
    }

    @Test
    void CitiesEquals() {
        List<String> cities = new ArrayList<String>(Arrays.asList("Baku", "Berlin", "Moscow", "London", "Paris", "New York", "Tokyo", "Ankara", "Tehran", "Madrid"));
        assertThat(cities, hasItem("Baku"));
        assertThat(cities, hasSize(10));
        assertThat(cities, hasItems("Baku", "Berlin", "Moscow", "London", "Paris"));
        assertThat(cities, contains("Baku", "Berlin", "Moscow", "London", "Paris", "New York", "Tokyo", "Ankara", "Tehran", "Madrid"));
        assertThat(cities, hasItems(startsWith("B"),not(startsWith("u"))));
    }
}
