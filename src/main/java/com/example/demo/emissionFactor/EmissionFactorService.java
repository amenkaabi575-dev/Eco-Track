package com.example.demo.emissionFactor;

import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorCreateDTO;
import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorUpdateDTO;
import com.example.demo.emissionFactor.entity.responseDTOs.EmissionFactorDTO;

import java.util.List;
import java.util.UUID;

public interface EmissionFactorService {


    EmissionFactorDTO createFactor(EmissionFactorCreateDTO dto);

    EmissionFactorDTO getFactorById(UUID id);

    List<EmissionFactorDTO> getAllFactors();

    List<EmissionFactorDTO> getGlobalFactors();

    EmissionFactorDTO updateFactorById(UUID id, EmissionFactorUpdateDTO dto);

    void deleteFactorById(UUID id);

}
