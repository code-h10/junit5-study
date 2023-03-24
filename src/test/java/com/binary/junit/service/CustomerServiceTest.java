package com.binary.junit.service;

import com.binary.junit.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerServiceTest {

    @Mock
    CustomerService customerService;

    @Test
    public void should_ReturnCustomerDetail_When_GivenCustomerNumber103() {
        Customer result = customerService.getCustomerDetail(103);
    }
}