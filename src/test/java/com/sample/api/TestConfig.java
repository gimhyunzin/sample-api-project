package com.sample.api;

import org.junit.BeforeClass;

/**
 * common test config settings
 */
public class TestConfig {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("spring.profiles.active", "local");
    }
}
