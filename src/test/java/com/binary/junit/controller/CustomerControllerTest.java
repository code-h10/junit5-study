package com.binary.junit.controller;

import com.binary.junit.model.Customer;
import com.binary.junit.repository.CustomerRepository;
import com.binary.junit.service.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerControllerTest {

//    @Autowired ApplicationContext applicationContext;
    @Autowired private MockMvc mockMvc;
    @MockBean private CustomerService customerService;
    private static Customer customer;

    @BeforeAll
    static void setUp() {
        customer = new Customer();
        customer.setCustomerName("IlYoungHwang");
        customer.setCustomerNumber(103);
        customer.setContractFirstName("IlYoung");
        customer.setContractLastName("Hwang");
        customer.setCity("Seoul");
        customer.setAddressLine1("");
        customer.setAddressLine2("");
        customer.setPhone("+8201054419104");
        customer.setState("");
    }

    @Test
    public void testCustomer() throws Exception {
        when(customerService.getCustomerDetail(anyInt())).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers/detail").param("customerNumber", "103"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"customerNumber\":103,\"customerName\":\"IlYoungHwang\",\"contractLastName\":\"Hwang\",\"contractFirstName\":\"IlYoung\",\"phone\":\"+8201054419104\",\"addressLine1\":\"\",\"addressLine2\":\"\",\"city\":\"Seoul\",\"state\":\"\",\"postalCode\":null,\"country\":null,\"saleRepEmployeeNumber\":0,\"creditLimit\":0}"))
                .andDo(print());
    }


//    @Test
//    public void testApplicationContext() {
//
//        String[] beanName = applicationContext.getBeanDefinitionNames();
//        Arrays.sort(beanName);
//
//        for (String name : beanName) {
//            System.out.println(name);
//        }
//    }

}