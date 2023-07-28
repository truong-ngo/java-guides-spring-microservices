package com.microservices.employee.client;

import com.microservices.employee.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("organization")
public interface OrganizationClient {
    @GetMapping("/api/organizations/code/{code}")
    OrganizationDto findByCode(@PathVariable String code);
}
