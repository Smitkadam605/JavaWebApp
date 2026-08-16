package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HelloServletTest {

    @Test
    public void applicationTest() {

        String message = "Hello from Java Web Application!";

        assertTrue(message.contains("Java"));

    }
}