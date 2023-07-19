package com.microservices.employee.service.impl;

import com.microservices.employee.dto.EmployeeDto;
import com.microservices.employee.exception.BusinessException;
import com.microservices.employee.repository.EmployeeRepo;
import com.microservices.employee.service.core.EmployeeService;
import com.microservices.employee.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto findById(Long id) {
        log.info("Request to get employee by id: {}", id);
        return employeeMapper.toDto(employeeRepo.findById(id)
                .orElseThrow(() -> new BusinessException("employeeNotFound")));
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        log.info("Request to save employee: {}", employeeDto);
        return employeeMapper.toDto(employeeRepo.save(employeeMapper.toEntity(employeeDto)));
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete employee with id: {}", id);
        employeeRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findAll() {
        log.info("Request to get all employee");
        return employeeRepo.findAll().stream().map(employeeMapper::toDto).toList();
    }
}
