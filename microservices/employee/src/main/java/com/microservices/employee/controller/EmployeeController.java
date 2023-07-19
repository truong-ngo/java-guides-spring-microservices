package com.microservices.employee.controller;

import com.microservices.employee.dto.EmployeeDto;
import com.microservices.employee.dto.EmployeeModel;
import com.microservices.employee.service.core.EmployeeModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeModelService employeeModelService;

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> findAll() {
        return ResponseEntity.ok(employeeModelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeModelService.findById(id));
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
