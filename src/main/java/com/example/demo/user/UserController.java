package com.example.demo.user;

import com.example.demo.user.enitity.requestDTOs.UserCreateDTO;
import com.example.demo.user.enitity.requestDTOs.UserUpdateDTO;
import com.example.demo.user.enitity.responseDTOs.UserDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers(){

        return userService.getAllUsers();

    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable UUID id){

        return userService.getUserById(id);

    }

    @PostMapping
    public UserDTO createUser(@RequestBody @Valid UserCreateDTO dto){

        return userService.createUser(dto);

    }

    @GetMapping("/organization/{id}")
    public List<UserDTO> getUsersByOrganizationId(@PathVariable UUID id){

        return userService.getUsersByOrganizationId(id);

    }

    @PutMapping("/{id}")
    public UserDTO updateUserById(@PathVariable UUID id, @RequestBody @Valid UserUpdateDTO dto){

        return userService.updateUserById(id,dto);

    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id){

        userService.deleteUserById(id);

    }

}
