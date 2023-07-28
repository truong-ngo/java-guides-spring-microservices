package com.microservices.employee.controller;

import com.microservices.employee.dto.DepartmentDto;
import com.microservices.employee.dto.EmployeeDto;
import com.microservices.employee.dto.EmployeeModel;
import com.microservices.employee.dto.OrganizationDto;
import com.microservices.employee.service.core.EmployeeModelService;
import com.microservices.employee.service.core.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeModelService employeeModelService;
    private final EmployeeService employeeService;

    @Retry(name = "employeeRetry", fallbackMethod = "retryFallback")
    @GetMapping
    public ResponseEntity<List<EmployeeModel>> findAll() {
        return ResponseEntity.ok(employeeModelService.findAll());
    }

    public ResponseEntity<List<EmployeeModel>> retryFallback(Throwable throwable) {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @CircuitBreaker(name = "employeeCB", fallbackMethod = "fallback")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> findById(@PathVariable Long id) {
        EmployeeModel body = employeeModelService.findById(id);
        return ResponseEntity.ok(body);
    }

    private ResponseEntity<EmployeeModel> fallback(Long id, Throwable throwable) {
        EmployeeDto employeeDto = employeeService.findById(id);
        return ResponseEntity.ok(new EmployeeModel(employeeDto, new DepartmentDto(), new OrganizationDto()));
    }

    @PostMapping
    public ResponseEntity<EmployeeModel> save(@RequestBody EmployeeModel employeeModel) {
        EmployeeModel body = employeeModelService.save(employeeModel);
        return body == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(employeeModelService.save(employeeModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> update(@RequestBody EmployeeModel employeeModel, @PathVariable Long id) {
        employeeModel.getEmployee().setId(id);
        return save(employeeModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        employeeModelService.delete(id);
        return ResponseEntity.ok("Delete successfully id: " + id);
    }
}
