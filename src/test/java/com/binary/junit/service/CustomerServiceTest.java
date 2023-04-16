package com.binary.junit.service;

import com.binary.junit.model.Customer;
import com.binary.junit.repository.CustomerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock private CustomerRepository customerRepository;
    @InjectMocks private CustomerService customerService;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setCustomerNumber(497);
        customer.setCustomerName("Kellys' Gift Shop Test");
        customer.setContractLastName("Snowden Test");
        customer.setContractFirstName("Tony Test");
        customer.setPhone("+8201054419104");
        customer.setAddressLine1("Seoul");
        customer.setAddressLine2(null);
        customer.setCity("gangnam");
        customer.setState(null);
        customer.setCountry("Korea");
        customer.setPostalCode(null);
        customer.setCreditLimit(10000);
        customer.setSaleRepEmployeeNumber(1612);
    }


    @Test
    public void should_ReturnTrue_When_UpdateContractName() {
        when(customerRepository.updateCustomerDetail(customer)).thenReturn(1);

        boolean result = customerService.updateCustomerDetail(customer);
        assertEquals(true, result);
    }

    @Test
    public void should_ReturnCustomer_When_GivenAnyInt() {
        when(customerRepository.getCustomerDetail(anyInt())).thenReturn(customer);

        Customer o = customerService.getCustomerDetail(customer.getCustomerNumber());
        assertEquals(customer, o);
    }

    @Test
    public void should_ReturnFalse_When_InsertCustomer() {
        when(customerRepository.getCustomerDetail(customer.getCustomerNumber())).thenReturn(customer);

        boolean b = customerService.insert(customer);
        verify(customerRepository, times(0)).insert(customer);

        assertEquals(false, b);
    }

    @Test
    public void should_ReturnTrue_When_InsertCustomer() {
        when(customerRepository.getCustomerDetail(customer.getCustomerNumber())).thenReturn(null);
        when(customerRepository.insert(customer)).thenReturn(1);

        boolean b = customerService.insert(customer);
        verify(customerRepository).insert(customer);

        assertEquals(true, b);
    }

}