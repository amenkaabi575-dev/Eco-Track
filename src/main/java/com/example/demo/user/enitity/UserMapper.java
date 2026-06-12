package com.example.demo.user.enitity;


import com.example.demo.user.enitity.requestDTOs.UserCreateDTO;
import com.example.demo.user.enitity.requestDTOs.UserUpdateDTO;
import com.example.demo.user.enitity.responseDTOs.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(source = "organization.id", target = "organizationId")
    UserDTO toDto(User user);

    @Mapping(target = "organization", ignore = true)
    User toEntity(UserCreateDTO dto);

    @Mapping(target = "organization", ignore = true)
    void updateEntityFromDto(UserUpdateDTO dto, @MappingTarget User user);

}
