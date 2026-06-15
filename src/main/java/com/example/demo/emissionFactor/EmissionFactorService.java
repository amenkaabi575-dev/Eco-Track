package com.example.demo.emissionFactor;

import com.example.demo.emissionFactor.entity.EmissionFactor;
import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorCreateDTO;
import com.example.demo.emissionFactor.entity.responseDTOs.EmissionFactorDTO;

import java.util.List;
import java.util.UUID;

public interface EmissionFactorService {


    EmissionFactorDTO createFactor(EmissionFactorCreateDTO dto);

    EmissionFactorDTO getFactorById(UUID id);

    List<EmissionFactor> getAllFactors();

    List<EmissionFactor> getGlobalFactors();

    EmissionFactorDTO updateFactorById(UUID id);

    void deleteFactorById(UUID id);

}
