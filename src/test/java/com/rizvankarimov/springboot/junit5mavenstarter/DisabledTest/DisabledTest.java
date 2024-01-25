package com.rizvankarimov.springboot.junit5mavenstarter.DisabledTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTest {
    @Test
    void Salam() {
        System.out.println("Salam");
    }

    @Test
    @Disabled("This method is wrong")
    void Hallo() {
        System.out.println("Hallo");
    }
}
