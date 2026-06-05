package com.example.demo.Organization.Entity;

import com.example.demo.Organization.Entity.RequestDTOs.OrganizationCreateUpdateDTO;
import com.example.demo.Organization.Entity.ResponseDTOs.OrganizationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {


    @Mapping(source = "id", target = "organizationId")
    OrganizationDTO toDto(Organization organization);


    @Mapping(target = "id",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    Organization toEntity(OrganizationCreateUpdateDTO dto);

    // Allows MapStruct to map the UUID to a String when Mapping to DTO
    default String mapUUIDtoString(UUID uuid){
        return uuid.toString();
    }

    // Allows MapStruct to map the String id to a UUID when Mapping from the DTO to the Entity
    default UUID mapStringToUUID(String uuid){
        return UUID.fromString(uuid);
    }
}
