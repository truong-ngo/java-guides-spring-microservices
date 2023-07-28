package com.microservices.employee.service.impl;

import com.microservices.employee.client.DepartmentClient;
import com.microservices.employee.client.DepartmentWebClient;
import com.microservices.employee.client.OrganizationClient;
import com.microservices.employee.dto.DepartmentDto;
import com.microservices.employee.dto.EmployeeDto;
import com.microservices.employee.dto.EmployeeModel;
import com.microservices.employee.dto.OrganizationDto;
import com.microservices.employee.service.core.EmployeeModelService;
import com.microservices.employee.service.core.EmployeeService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeModelServiceImpl implements EmployeeModelService {
    private final EmployeeService employeeService;
    private final DepartmentClient departmentClient;
    private final DepartmentWebClient departmentWebClient;
    private final OrganizationClient organizationClient;

    @Override
    public EmployeeModel findById(Long id) {
        EmployeeDto employeeDto = employeeService.findById(id);
        DepartmentDto departmentDto = departmentClient.findByCode(employeeDto.getDepartmentCode());
        OrganizationDto organizationDto = organizationClient.findByCode(employeeDto.getOrganizationCode());
        return new EmployeeModel(employeeDto, departmentDto, organizationDto);
    }

    @Override
    public EmployeeModel save(EmployeeModel employeeModel) {
        EmployeeModel result = null;
        try {
            DepartmentDto departmentDto = departmentWebClient.findByCode(employeeModel.getDepartment().getCode());
            OrganizationDto organizationDto = organizationClient.findByCode(employeeModel.getOrganization().getCode());
            EmployeeDto employeeDto = employeeService.save(employeeModel.getEmployee());
            result = new EmployeeModel(employeeDto, departmentDto, organizationDto);
        } catch (FeignException e) {
            log.info("Cannot save employee");
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

    @Override
    public List<EmployeeModel> findAll() {
        return employeeService.findAll().stream().map(e -> findById(e.getId())).toList();
    }
}
