package com.example.demo.organization;

import com.example.demo.common.exception.DuplicateResourceException;
import com.example.demo.organization.entity.Organization;
import com.example.demo.organization.entity.OrganizationMapper;
import com.example.demo.organization.entity.requestDTOs.OrganizationCreateDTO;
import com.example.demo.organization.entity.requestDTOs.OrganizationUpdateDTO;
import com.example.demo.organization.entity.responseDTOs.OrganizationDTO;
import com.example.demo.common.exception.ResourceNotFoundException;
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
                .orElseThrow(()-> new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));
        return organizationMapper.toDto(organization);
    }

    @Override
    public OrganizationDTO createOrganization(OrganizationCreateDTO dto) {

        // Checking name uniqueness
        if(organizationRepository.existsByName(dto.getName())){
            throw new DuplicateResourceException("Organization name already exists",
                    "ORGANIZATION_NAME_DUPLICATE");
        }

        if(organizationRepository.existsByTaxId(dto.getTaxId())){
            throw new DuplicateResourceException("Organization Tax ID already exists",
                    "ORGANIZATION_TAX_ID_DUPLICATE");
        }

        Organization organization = organizationRepository
                .save(organizationMapper.toEntity(dto));

        return organizationMapper.toDto(organization);

    }


    @Override
    @Transactional
    public OrganizationDTO updateOrganizationById(UUID id, OrganizationUpdateDTO dto) {

        Organization organization = organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization not found"));

        String newName = dto.getName();

        if( newName != null &&
            !newName.equals(organization.getName()) &&
            organizationRepository.existsByName(newName)

        ){
            throw new DuplicateResourceException("Organization name already exists",
                    "ORGANIZATION_NAME_DUPLICATE");
        }

        organizationMapper.updateEntityFromDto(dto,organization);

        return organizationMapper.toDto(organization);

    }

    @Override
    public void deleteOrganizationById(UUID id) {
        organizationRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));

        organizationRepository.deleteById(id);
    }
}
