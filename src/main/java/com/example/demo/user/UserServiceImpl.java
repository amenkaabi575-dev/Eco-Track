package com.example.demo.user;


import com.example.demo.common.exception.BusinessException;
import com.example.demo.common.exception.DuplicateResourceException;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.organization.OrganizationRepository;
import com.example.demo.organization.entity.Organization;
import com.example.demo.user.enitity.User;
import com.example.demo.user.enitity.UserMapper;
import com.example.demo.user.enitity.UserRole;
import com.example.demo.user.enitity.requestDTOs.UserCreateDTO;
import com.example.demo.user.enitity.requestDTOs.UserUpdateDTO;
import com.example.demo.user.enitity.responseDTOs.UserDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUserById(UUID id) {
        return userMapper.toDto(
                userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found","USER_NOT_FOUND"))
        );
    }

    @Override
    public UserDTO createUser(UserCreateDTO dto) {

        if(userRepository.existsByEmail(dto.getEmail())){
            throw new DuplicateResourceException("Email already in use","DUPLICATE_EMAIL");
        }

        if(userRepository.existsByUsername(dto.getUsername())){
            throw new DuplicateResourceException("Username already in use","DUPLICATE_USERNAME");
        }


        if(dto.getOrganizationId() != null && dto.getUserRole()==UserRole.ADMIN ){

                throw new BusinessException("ADMIN cannot belong to any organization","ADMIN_CANNOT_BELONG_TO_ORGANIZATION", HttpStatus.BAD_REQUEST);

        }

        Organization organization = null;
        if (dto.getOrganizationId() != null){

            organization = organizationRepository
                    .findById(dto.getOrganizationId())
                    .orElseThrow(()-> new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));

        }


        User user = userMapper.toEntity(dto);

        user.setOrganization(organization);
        return userMapper.toDto(userRepository.save(user));


    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public List<UserDTO> getUsersByOrganizationId(UUID id) {
        organizationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));

        return userRepository.findUsersByOrganizationId(id).stream().map(userMapper::toDto).toList();
    }

    @Override
    @Transactional
    public UserDTO updateUserById(UserUpdateDTO dto, UUID id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found","USER_NOT_FOUND"));

        if(dto.getEmail()!=null && userRepository.existsByEmailAndIdNot(dto.getEmail(), user.getId())){
            throw new DuplicateResourceException("Email already in use","DUPLICATE_EMAIL");
        }

        UserRole finalRole = dto.getUserRole() != null ? dto.getUserRole() : user.getUserRole();
        Organization finalOrganization;
        if(finalRole == UserRole.ADMIN){
            if (dto.getOrganizationId()!=null){
                throw new BusinessException("ADMIN cannot belong to any organization","ADMIN_CANNOT_BELONG_TO_ORGANIZATION", HttpStatus.BAD_REQUEST);
            }
            finalOrganization = null;
        } else if (dto.getOrganizationId() == null ) {
            if(user.getOrganization()==null){
                throw new BusinessException(
                        "Organization is required for this role",
                        "ORGANIZATION_REQUIRED_FOR_ROLE",
                        HttpStatus.BAD_REQUEST
                );
            }
            finalOrganization = user.getOrganization();
        }
        else {
            finalOrganization = organizationRepository
                    .findById(dto.getOrganizationId())
                    .orElseThrow(()-> new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));
        }

        userMapper.updateEntityFromDto(dto,user);
        user.setOrganization(finalOrganization);

        return userMapper.toDto(user);
    }

    @Override
    public void deleteUserById(UUID id) {

        userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found","USER_NOT_FOUND"));
        userRepository.deleteById(id);

    }
}
