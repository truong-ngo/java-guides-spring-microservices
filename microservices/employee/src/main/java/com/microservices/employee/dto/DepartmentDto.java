package com.microservices.employee.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private String id;
    private String name;
    private String description;
    private String code;
}
