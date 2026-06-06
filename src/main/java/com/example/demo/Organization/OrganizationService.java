package com.example.demo.Organization;

import com.example.demo.Organization.Entity.RequestDTOs.OrganizationCreateDTO;
import com.example.demo.Organization.Entity.RequestDTOs.OrganizationUpdateDTO;
import com.example.demo.Organization.Entity.ResponseDTOs.OrganizationDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {


    List<OrganizationDTO> getAllOrganizations();

    OrganizationDTO getOrganizationById(UUID id);

    OrganizationDTO createOrganization(OrganizationCreateDTO dto);

    OrganizationDTO updateOrganizationById(UUID id, OrganizationUpdateDTO dto);

    void deleteOrganizationById(UUID id);

}
