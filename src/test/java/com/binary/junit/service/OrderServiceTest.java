package com.binary.junit.service;

import com.binary.junit.model.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class OrderServiceTest {

    private Customer customer;

    @BeforeEach
    void initAll() {
        customer = new Customer();
        customer.setCustomerNumber(103);
        customer.setCustomerName("Atelier graphique");
        customer.setContractLastName("Schmitt");
        customer.setContractFirstName("Carine ");
    }


    @Test
    public void groupedAssertions() {
        assertAll("customer",
                () -> assertEquals(103, customer.getCustomerNumber()),
                () -> assertEquals("Atelier graphique", customer.getCustomerName()));
    }

    @Test
    public void dependentAssertions() {
        assertAll("customer",
                () -> {
                    String contractFirstName = customer.getContractFirstName();
                    assertNotNull(contractFirstName);

                    assertAll("customer",
                            () -> assertTrue(contractFirstName.startsWith("C")),
                            () -> assertTrue(contractFirstName.endsWith(" ")));
                });
    }

    @Test
    public void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
    private int divide(int a, int b) throws ArithmeticException{
        return a / b;
    }

    @Test
    public void timeoutNotExceeded() {

        assertTimeout(ofMinutes(1), () -> { // 1분이상걸리면 에러
            Thread.sleep(100000);
        });
    }

    @Test
    public void timeNotExceedWithResult() {
        String actualResult = assertTimeout(ofMinutes(1), () -> {
            return "a result";
        });

        assertEquals("a result", actualResult);
    }

    @Test
    public void timeoutNotExceededWithMethod() {
        String actualGreeting = assertTimeout(ofMinutes(1), OrderServiceTest::greeting);
        assertEquals("Hello, World", actualGreeting);
    }
    private static String greeting() {
        return "Hello, World";
    }


    @Test
    public void timeoutExceeded() {
        assertTimeout(ofMillis(10), () ->{
            Thread.sleep(100);
        });
    }



}