package com.example.demo.Organization;

import com.example.demo.Organization.Entity.Organization;
import com.example.demo.Organization.Entity.OrganizationMapper;
import com.example.demo.Organization.Entity.RequestDTOs.OrganizationCreateDTO;
import com.example.demo.Organization.Entity.RequestDTOs.OrganizationUpdateDTO;
import com.example.demo.Organization.Entity.ResponseDTOs.OrganizationDTO;
import com.example.demo.common.Exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationRepository.findAll().stream().map(organizationMapper::toDto).toList();
    }

    @Override
    public OrganizationDTO getOrganizationById(UUID id) {
        Organization organization = organizationRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Organization not found"));
        return organizationMapper.toDto(organization);
    }

    @Override
    public OrganizationDTO createOrganization(OrganizationCreateDTO dto) {
        Organization organization = organizationRepository
                .save(organizationMapper.toEntity(dto));

        return organizationMapper.toDto(organization);

    }


    @Override
    @Transactional
    public OrganizationDTO updateOrganizationById(UUID id, OrganizationUpdateDTO dto) {
        Organization organization = organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization not found"));
        if (dto.getName()!=null && !dto.getName().equals(organization.getName())){
            organization.setName(dto.getName());
        }
        if (dto.getTaxId()!=null && !dto.getTaxId().equals(organization.getTaxId())){
            organization.setTaxId(dto.getTaxId());
        }
        if (dto.getSector()!=null && !dto.getSector().equals(organization.getSector())){
            organization.setSector(dto.getSector());
        }

        return organizationMapper.toDto(organization);


    }

    @Override
    public void deleteOrganizationById(UUID id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization not found"));
        organizationRepository.deleteById(id);
    }
}
