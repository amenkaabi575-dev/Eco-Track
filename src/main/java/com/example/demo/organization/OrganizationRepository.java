package com.example.demo.organization;

import com.example.demo.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {


    boolean existsByName(String name);
    boolean existsByTaxId(String taxId);
}
