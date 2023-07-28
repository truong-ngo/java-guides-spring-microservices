package com.microservices.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organization;
}
