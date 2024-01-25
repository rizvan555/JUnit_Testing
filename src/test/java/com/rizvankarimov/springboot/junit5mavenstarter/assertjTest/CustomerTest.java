package com.rizvankarimov.springboot.junit5mavenstarter.assertjTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerTest {
    @Test
    void stringTest() {
        String city1 = "Istanbul";
        assertThat(city1)
                .describedAs("This is error message") // Buraya error mesajini yaziriq.
                .isEqualTo("Istanbul")
                .startsWith("Ist")
                .endsWith("bul")
                .contains("tan")
                .isNotEmpty()
                .isNotNull()
                .doesNotContain("ankara");



    }
}
