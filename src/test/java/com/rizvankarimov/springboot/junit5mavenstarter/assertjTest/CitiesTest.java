package com.rizvankarimov.springboot.junit5mavenstarter.assertjTest;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CitiesTest {

    List<String> citiesAz = new ArrayList<>(Arrays.asList("Baku", "Khachmaz", "Quba", "Sumgayit", "Ismayilli"));
    List<String> citiesDe = new ArrayList<>(Arrays.asList("Berlin", "Kaiserslautern", "Frankfurt", "Cologne", "Mannheim"));

    @Test
    void containInList() {
        List<String> cities = new ArrayList<>(Arrays.asList("Baku", "Khachmaz", "Quba", "Sumgayit", "Ismayilli"));
        assertThat(cities)
                .describedAs("This is error message")
                .contains("Baku")
                .doesNotContain("Paris")
                .doesNotContainNull()
                .doesNotHaveDuplicates()
                .doesNotHaveAnyElementsOfTypes(Integer.class)
                .hasSize(5);

        //Buradaki listemizde yalniz "Az" seherleri olmali oldugunu test edirik.
        List<String> cities2 = new ArrayList<>(Arrays.asList("Baku", "Khachmaz", "Quba", "Sumgayit", "Ismayilli"));
        assertThat(cities2)
                .have(citiesAz());

        //Buradaki listemizde yalniz "De" seherleri olmali oldugunu test edirik.
        List<String> cities3 = new ArrayList<>(Arrays.asList("Berlin", "Kaiserslautern", "Frankfurt", "Cologne", "Mannheim"));
        assertThat(cities3)
                .have(citiesDe());

        //Buradaki listemizde 2 dene "Az" ve 3 dene de "De" seheri olmali oldugunu test edirik.
        List<String> cities4 = new ArrayList<>(Arrays.asList("Baku", "Khachmaz", "Frankfurt", "Cologne", "Mannheim"));
        assertThat(cities4)
                .haveExactly(2, citiesAz())
                .haveExactly(3, citiesDe());


    }

    private Condition<? super String> citiesAz(){
        return new Condition<String>() {
            @Override
            public boolean matches(String value) {
                return citiesAz.contains(value);
            }
        };
    }

    private Condition<? super String> citiesDe(){
        return new Condition<String>() {
            @Override
            public boolean matches(String value) {
                return citiesDe.contains(value);
            }
        };
    }


}
