package com.binary.junit.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
public class OrderedTest {

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
