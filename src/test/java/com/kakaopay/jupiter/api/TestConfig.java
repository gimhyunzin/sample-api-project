package com.kakaopay.jupiter.api;

import org.junit.BeforeClass;

public class TestConfig {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("spring.profiles.active", "local");
    }
}
