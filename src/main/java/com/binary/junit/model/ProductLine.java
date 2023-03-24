package com.binary.junit.model;

import lombok.Data;

@Data
public class ProductLine {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;
}
