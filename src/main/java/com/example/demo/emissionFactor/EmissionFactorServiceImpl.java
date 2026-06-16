package com.example.demo.emissionFactor;

import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.emissionFactor.entity.EmissionFactor;
import com.example.demo.emissionFactor.entity.EmissionFactorMapper;
import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorCreateDTO;
import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorUpdateDTO;
import com.example.demo.emissionFactor.entity.responseDTOs.EmissionFactorDTO;
import com.example.demo.organization.OrganizationRepository;
import com.example.demo.organization.entity.Organization;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmissionFactorServiceImpl implements EmissionFactorService{

    private final EmissionFactorRepository emissionFactorRepository;
    private final EmissionFactorMapper emissionFactorMapper;
    private final OrganizationRepository organizationRepository;

    @Override
    public EmissionFactorDTO createFactor(EmissionFactorCreateDTO dto) {
        Organization organization = organizationRepository
                .findById(dto.getOrganizationId())
                .orElseThrow(()-> new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));

        EmissionFactor factor = emissionFactorMapper.toEntity(dto);
        factor.setOrganization(organization);
        return emissionFactorMapper.toDto(emissionFactorRepository.save(factor));
    }

    @Override
    public EmissionFactorDTO getFactorById(UUID id) {
        EmissionFactor factor = emissionFactorRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Emission factor not found","EMISSION_FACTOR_NOT_FOUND"));
        return emissionFactorMapper.toDto(factor);
    }

    @Override
    public List<EmissionFactorDTO> getAllFactors() {
        return emissionFactorRepository.findAllFactors().stream().map(emissionFactorMapper::toDto).toList();
    }

    @Override
    public List<EmissionFactorDTO> getGlobalFactors() {
        return emissionFactorRepository.findByIsGlobalTrue().stream().map(emissionFactorMapper::toDto).toList();
    }

    @Override
    @Transactional
    public EmissionFactorDTO updateFactorById(UUID id, EmissionFactorUpdateDTO dto) {
        EmissionFactor factor = emissionFactorRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Emission factor not found", "EMISSION_FACTOR_NOT_FOUND"));
        emissionFactorMapper.updateFactorFromDto(dto,factor);
        return emissionFactorMapper.toDto(factor);
    }

    @Override
    public void deleteFactorById(UUID id) {

        emissionFactorRepository.delete(
                emissionFactorRepository
                        .findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Emission factor not found","EMISSION_FACTOR_NOT_FOUND"))
        );

    }
}
