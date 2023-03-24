package com.binary.junit.controller;

import com.binary.junit.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    private final CustomerService customerService;

    @GetMapping("/order/history")
    public List<Map> orderHistoriesByCustomerNumber(@RequestParam int customerNumber) {
        return customerService.orderHistoriesByCustomerNumber(customerNumber);
    }
}
