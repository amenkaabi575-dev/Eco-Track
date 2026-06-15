package com.example.demo.emissionFactor;

import com.example.demo.emissionFactor.entity.EmissionFactor;
import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorCreateDTO;
import com.example.demo.emissionFactor.entity.responseDTOs.EmissionFactorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmissionFactorServiceImpl implements EmissionFactorService{

    private final EmissionFactorRepository emissionFactorRepository;

    @Override
    public EmissionFactorDTO createFactor(EmissionFactorCreateDTO dto) {
        return null;
    }

    @Override
    public EmissionFactorDTO getFactorById(UUID id) {
        return null;
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return List.of();
    }

    @Override
    public List<EmissionFactor> getGlobalFactors() {
        return List.of();
    }

    @Override
    public EmissionFactorDTO updateFactorById(UUID id) {
        return null;
    }

    @Override
    public void deleteFactorById(UUID id) {

    }
}
