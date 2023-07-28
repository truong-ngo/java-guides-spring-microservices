package com.microservices.organization.service.impl;

import com.microservices.organization.dto.OrganizationDto;
import com.microservices.organization.repository.OrganizationRepo;
import com.microservices.organization.service.core.OrganizationService;
import com.microservices.organization.service.mapper.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepo organizationRepo;
    private final OrganizationMapper organizationMapper;

    @Override
    public OrganizationDto findById(Long id) {
        log.info("Request to get organization: id = {}", id);
        return organizationMapper.toDto(organizationRepo.findById(id).orElse(null));
    }

    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        log.info("Request to save organization: {}", organizationDto);
        return organizationMapper.toDto(organizationRepo.save(organizationMapper.toEntity(organizationDto)));
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete organization: id = {}", id);
        organizationRepo.deleteById(id);
    }

    @Override
    public List<OrganizationDto> findAll() {
        log.info("Request to get all organization:");
        return organizationRepo.findAll().stream().map(organizationMapper::toDto).toList();
    }

    @Override
    public OrganizationDto findByCode(String code) {
        log.info("Request to get organization: code = {}", code);
        return organizationMapper.toDto(organizationRepo.findByCode(code).orElse(null));
    }
}
