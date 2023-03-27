package com.binary.junit.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LifeCycleTest {

    @BeforeAll
    void beforeAllTest() {
        System.out.println("Before All Test");
    }

    @AfterAll
    void afterAllTest() {
        System.out.println("After All Test");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before Each Test");
    }

    @AfterEach
    void AfterEachTest() {
        System.out.println("After Each Test");
    }

    @Test
    @Order(1)
    public void firstTest() {
        System.out.println("First Test");
    }

    @Test
    @Order(2)
    public void secondTest() {
        System.out.println("Second Test");
    }

    @Test
    @Order(3)
    public void thirdTest() {
        System.out.println("Third Test");
    }
}
