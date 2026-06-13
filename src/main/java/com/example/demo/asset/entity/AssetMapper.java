package com.example.demo.asset.entity;

import com.example.demo.asset.entity.requestDTOs.AssetCreateDTO;
import com.example.demo.asset.entity.requestDTOs.AssetUpdateDTO;
import com.example.demo.asset.entity.responseDTOs.AssetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AssetMapper {


    @Mapping(source = "organization.id",target = "organizationId")
    AssetDTO toDto(Asset asset);


    @Mapping(target = "organization", ignore = true)
    Asset toEntity(AssetCreateDTO dto);


    void updateEntityFromDto(AssetUpdateDTO dto, @MappingTarget Asset asset);

}
