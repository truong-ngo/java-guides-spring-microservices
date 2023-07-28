package com.javaguides.base.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String id;
    private String name;
    private int quantity;
    private Double price;
}
