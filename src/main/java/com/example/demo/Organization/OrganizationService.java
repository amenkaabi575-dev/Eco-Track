package com.example.demo.Organization;

import com.example.demo.Organization.Entity.RequestDTOs.OrganizationCreateUpdateDTO;
import com.example.demo.Organization.Entity.ResponseDTOs.OrganizationDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {


    List<OrganizationDTO> getAllOrganizations();

    OrganizationDTO getOrganizationById(UUID uuid);

    OrganizationDTO createOrganization(OrganizationCreateUpdateDTO dto);

    OrganizationDTO updateOrganizationById(UUID uuid,OrganizationCreateUpdateDTO dto);

    void deleteOrganizationById(UUID uuid);

}
