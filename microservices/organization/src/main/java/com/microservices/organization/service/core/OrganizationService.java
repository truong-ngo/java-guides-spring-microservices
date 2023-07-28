package com.microservices.organization.service.core;

import com.microservices.organization.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService extends CrudService<OrganizationDto, Long> {
    List<OrganizationDto> findAll();
    OrganizationDto findByCode(String code);
}
