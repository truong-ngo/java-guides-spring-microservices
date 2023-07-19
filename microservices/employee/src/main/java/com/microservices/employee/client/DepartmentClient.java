package com.microservices.employee.client;

import com.microservices.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("department")
public interface DepartmentClient {
    @GetMapping("/api/departments/code/{code}")
    DepartmentDto findByCode(@PathVariable String code);
}
