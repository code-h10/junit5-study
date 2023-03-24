package com.binary.junit.controller;

import com.binary.junit.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/histories")
    public List<Map> getOrderHistories(@RequestParam int customerNumber) {
        return orderService.getOrderHistories(customerNumber);
    }

    @GetMapping("/detail")
    public Map getOrderDetail(@RequestParam int customerNumber, @RequestParam int orderNumber) {
        return orderService.getOrderDetail(customerNumber, orderNumber);
    }

}
