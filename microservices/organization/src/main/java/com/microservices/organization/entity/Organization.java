package com.microservices.organization.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "organization")
public class Organization {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDate createdDate;
}
