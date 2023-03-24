package com.binary.junit.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Payment {
    private int customerNumber;
    private String checkNumber;
    private LocalDate paymentDate;
    private BigDecimal amount;
 }
