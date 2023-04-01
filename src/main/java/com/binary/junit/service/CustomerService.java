package com.binary.junit.service;

import com.binary.junit.model.Customer;
import com.binary.junit.model.OrderDetail;
import com.binary.junit.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerDetail(int customerNumber) {
        return customerRepository.getCustomerDetail(customerNumber);
    }

    public String updateCustomerDetail(Customer customerDetail) {
        int updateStatus = customerRepository.updateCustomerDetail(customerDetail);

        if (updateStatus == 1) {
            return "success";
        } else {
            return "failure";
        }

    }

}
