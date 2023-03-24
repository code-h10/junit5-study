package com.binary.junit.service;

import com.binary.junit.model.OrderDetail;
import com.binary.junit.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Map> orderHistoriesByCustomerNumber(int customerNumber) {
        return customerRepository.orderHistoriesByCustomerNumber(customerNumber);
    }

}
