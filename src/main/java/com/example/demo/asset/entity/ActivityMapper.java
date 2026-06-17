package com.example.demo.asset.entity;

import com.example.demo.activity.entity.Activity;
import com.example.demo.activity.entity.requestDTOs.ActivityCreateDTO;
import com.example.demo.activity.entity.requestDTOs.ActivityUpdateDTO;
import com.example.demo.activity.entity.responseDTOs.ActivityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import javax.swing.text.html.parser.Entity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ActivityMapper {


    @Mapping(source = "asset.name", target = "assetName")
    @Mapping(source = "asset.id",target = "asset_id")
    @Mapping(source = "emissionFactor.name", target = "emissionFactorName")
    @Mapping(source = "emissionFactor.id",target = "emissionFactorId")
    ActivityDTO toDto(Activity activity);



    @Mapping(target = "asset", ignore = true)
    @Mapping(target = "emissionFactor", ignore = true)
    Activity toEntity(ActivityCreateDTO dto);




    void updateActivityFromDto(ActivityUpdateDTO dto, @MappingTarget Activity activity);

}
