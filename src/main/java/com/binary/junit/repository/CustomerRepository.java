package com.binary.junit.repository;

import com.binary.junit.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerRepository {

    Customer getCustomerDetail(int customerNumber);
    int updateCustomerDetail(Customer customerDetail);
    int insert(Customer customer);

}
