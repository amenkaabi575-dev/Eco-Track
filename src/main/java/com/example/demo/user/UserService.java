package com.example.demo.user;

import com.example.demo.user.enitity.User;
import com.example.demo.user.enitity.requestDTOs.UserCreateDTO;
import com.example.demo.user.enitity.requestDTOs.UserUpdateDTO;
import com.example.demo.user.enitity.responseDTOs.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDTO getUserById(UUID id);

    UserDTO createUser(UserCreateDTO dto);

    List<UserDTO> getAllUsers();

    List<UserDTO> getUsersByOrganizationId(UUID id);

    UserDTO updateUserById(UserUpdateDTO dto, UUID id);

    void deleteUserById(UUID id);

}
