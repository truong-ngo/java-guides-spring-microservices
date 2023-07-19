package com.microservices.employee.service.mapper;


import com.microservices.employee.dto.EmployeeDto;
import com.microservices.employee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeDto> {
}
