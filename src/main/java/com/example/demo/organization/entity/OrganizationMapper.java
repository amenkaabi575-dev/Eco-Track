package com.example.demo.organization.entity;

import com.example.demo.organization.entity.requestDTOs.OrganizationCreateDTO;
import com.example.demo.organization.entity.requestDTOs.OrganizationUpdateDTO;
import com.example.demo.organization.entity.responseDTOs.OrganizationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.UUID;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrganizationMapper {


    @Mapping(source = "id", target = "organizationId")
    OrganizationDTO toDto(Organization organization);


    @Mapping(target = "id",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    Organization toEntity(OrganizationCreateDTO dto);

    void updateEntityFromDto(OrganizationUpdateDTO dto, @MappingTarget Organization entity);

    // Allows MapStruct to map the UUID to a String when Mapping to DTO
    default String mapUUIDtoString(UUID uuid){
        return uuid == null ? null : uuid.toString();
    }

    // Allows MapStruct to map the String id to a UUID when Mapping from the DTO to the Entity
    default UUID mapStringToUUID(String uuid){
        return uuid == null ? null : UUID.fromString(uuid);
    }
}
