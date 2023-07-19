package com.microservices.employee.service.core;

import com.microservices.employee.dto.EmployeeModel;

import java.util.List;

public interface EmployeeModelService extends CrudService<EmployeeModel, Long> {
    List<EmployeeModel> findAll();
}
