package com.javaguides.order.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private int quantity;
    private Double price;
}
