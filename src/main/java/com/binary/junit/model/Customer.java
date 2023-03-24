package com.binary.junit.model;

import lombok.Data;

@Data
public class Customer {
    private int customerNumber;
    private String customerName;
    private String contractLastName;
    private String contractFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int saleRepEmployeeNumber;
    private int creditLimit;

}
