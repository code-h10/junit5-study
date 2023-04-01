package com.binary.junit.service;

import com.binary.junit.model.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerServiceTest {

    @MockBean CustomerService customerService;
    private Customer customer;

    @BeforeAll
    void setUp() {
        customer = new Customer();
        customer.setCustomerNumber(103);
        customer.setContractLastName("Hwang");
        customer.setContractFirstName("IlYoung");
    }

    @Disabled
    @Test
    public void should_ReturnCustomerDetail_When_GivenCustomerNumber103() {
        Customer result = customerService.getCustomerDetail(103);
        assertEquals(result.getCustomerNumber(), 103);
        assertEquals(result.getCustomerNumber(), is(equalTo(103)));
    }

    @Test
    public void should_ReturnSuccess_When_UpdateContractName() {
        when(customerService.updateCustomerDetail(customer)).thenReturn("success");

        String result = customerService.updateCustomerDetail(customer);
        assertEquals(result, "success");

    }
}