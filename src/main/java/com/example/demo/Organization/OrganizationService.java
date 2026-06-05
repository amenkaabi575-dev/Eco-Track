package com.example.demo.Organization;

import com.example.demo.Organization.Entity.RequestDTOs.OrganizationCreateUpdateDTO;
import com.example.demo.Organization.Entity.ResponseDTOs.OrganizationDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {


    List<OrganizationDTO> getAllOrganizations();

    OrganizationDTO getOrganizationById(UUID id);

    OrganizationDTO createOrganization(OrganizationCreateUpdateDTO dto);

    OrganizationDTO updateOrganizationById(UUID id,OrganizationCreateUpdateDTO dto);

    void deleteOrganizationById(UUID id);

}
