package com.binary.junit.service;

import com.binary.junit.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Map> getOrderHistories(int customerNumber) {
        return orderRepository.getOrderHistories(customerNumber);
    }

    public Map getOrderDetail(int customerNumber, int orderNumber) {
        return orderRepository.getOrderDetail(customerNumber, orderNumber);
    }
}
