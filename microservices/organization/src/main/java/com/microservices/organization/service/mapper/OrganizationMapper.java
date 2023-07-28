package com.microservices.organization.service.mapper;


import com.microservices.organization.dto.OrganizationDto;
import com.microservices.organization.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends EntityMapper<Organization, OrganizationDto> {
}
