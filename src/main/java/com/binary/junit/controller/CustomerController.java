package com.binary.junit.controller;

import com.binary.junit.model.Customer;
import com.binary.junit.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/detail")
    public Customer getCustomerDetail(int customerNumber) {
        return customerService.getCustomerDetail(customerNumber);
    }

    @PostMapping("/detail")
    public boolean updateCustomerDetail(@RequestParam Customer customerDetail) {
        return customerService.updateCustomerDetail(customerDetail);
    }

    @PostMapping("/inserted")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insert(customer);
    }

    @PutMapping("/updated")
    public void updateCustomer(@RequestBody Customer customer) {

    }

}
