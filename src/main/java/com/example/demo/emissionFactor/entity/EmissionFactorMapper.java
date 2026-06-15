package com.example.demo.emissionFactor.entity;

import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorCreateDTO;
import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorUpdateDTO;
import com.example.demo.emissionFactor.entity.responseDTOs.EmissionFactorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmissionFactorMapper {

    @Mapping(source = "organization.name", target = "organizationName")
    EmissionFactorDTO toDto(EmissionFactor entity);


    EmissionFactor toEntity(EmissionFactorCreateDTO dto);

    void updateFactorFromDto(EmissionFactorUpdateDTO dto, @MappingTarget EmissionFactor entity);

}
