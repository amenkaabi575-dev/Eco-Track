package com.example.demo.organization;

import com.example.demo.organization.entity.RequestDTOs.OrganizationCreateDTO;
import com.example.demo.organization.entity.RequestDTOs.OrganizationUpdateDTO;
import com.example.demo.organization.entity.ResponseDTOs.OrganizationDTO;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {


    List<OrganizationDTO> getAllOrganizations();

    OrganizationDTO getOrganizationById(UUID id);

    OrganizationDTO createOrganization(OrganizationCreateDTO dto);

    OrganizationDTO updateOrganizationById(UUID id, OrganizationUpdateDTO dto);

    void deleteOrganizationById(UUID id);

}
