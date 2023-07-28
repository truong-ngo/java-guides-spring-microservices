package com.microservices.employee.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrganizationDto {
    private Long id;
    private String name;
    private String description;
    private String code;
    private LocalDate createdDate;
}
