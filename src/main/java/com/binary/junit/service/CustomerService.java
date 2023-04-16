package com.binary.junit.service;

import com.binary.junit.model.Customer;
import com.binary.junit.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerDetail(int customerNumber) {
        return customerRepository.getCustomerDetail(customerNumber);
    }

    public boolean updateCustomerDetail(Customer customerDetail) {
        int c = customerRepository.updateCustomerDetail(customerDetail);

        if (c == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(Customer customer) {
        Customer o = getCustomerDetail(customer.getCustomerNumber());
        if (nonNull(o)) {
            log.info("Exists CustomerNumber");
            return false;
        }

        int c = customerRepository.insert(customer);
        if (c >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
