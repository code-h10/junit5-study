package com.binary.junit.service;

import com.binary.junit.model.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("고객정보")
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @DisplayName("고객상세정보 조회")
    @Test
    public void should_ReturnCustomerDetail_When_GivenCustomerNumber103() {
        Customer result = customerService.getCustomerDetail(103);
        assertEquals(result.getCustomerNumber(), 103);
        assertEquals(result.getCustomerNumber(), is(equalTo(103)));
    }

    @DisplayName("기타 테스트")
    @Test
    public void should_True_When_GivenNumberIsEquals() {
        int x = 10;
        int y = 10;
        assertEquals(x, y);
    }
}