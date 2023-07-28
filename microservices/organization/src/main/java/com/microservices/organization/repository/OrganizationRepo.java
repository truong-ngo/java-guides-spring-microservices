package com.microservices.organization.repository;

import com.microservices.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {
    Optional<Organization> findByCode(String code);
}
