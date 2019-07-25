package com.oocl.packagebooking.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class HelloWorldControllerTest {
    @Test
    public void should_get_hello_world_when_getHelloWorld() {
        // GIVEN
        HelloWorldController helloWorldController = new HelloWorldController();

        // WHEN
        String helloWorld = helloWorldController.getHelloWorld();

        // THEN
        Assertions.assertEquals("Hello world", helloWorld);
    }
}