package com.binary.junit.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderRepository {

    List<Map> getOrderHistories(int customerNumber);
    Map getOrderDetail(int customerNumber, int orderNumber);
}
