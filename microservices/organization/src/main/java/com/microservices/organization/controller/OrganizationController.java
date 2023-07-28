package com.microservices.organization.controller;

import com.microservices.organization.dto.OrganizationDto;
import com.microservices.organization.service.core.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> findAll() {
        return ResponseEntity.ok(organizationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.findById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OrganizationDto> findByCode(@PathVariable String code) {
        return ResponseEntity.ok(organizationService.findByCode(code));
    }

    @PostMapping
    public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto organizationDto) {
        return ResponseEntity.ok(organizationService.save(organizationDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDto> update(@PathVariable Long id, @RequestBody OrganizationDto organizationDto) {
        organizationDto.setId(id);
        return ResponseEntity.ok(organizationService.save(organizationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        organizationService.delete(id);
        return ResponseEntity.ok("Delete successfully id: " + id);
    }
}
