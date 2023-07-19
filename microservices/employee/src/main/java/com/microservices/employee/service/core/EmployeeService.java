package com.microservices.employee.service.core;

import com.microservices.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService extends CrudService<EmployeeDto, Long> {
    List<EmployeeDto> findAll();
}
