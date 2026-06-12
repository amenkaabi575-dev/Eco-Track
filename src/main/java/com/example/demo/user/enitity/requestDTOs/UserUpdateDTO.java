package com.example.demo.user.enitity.requestDTOs;


import com.example.demo.user.enitity.UserRole;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDTO {

    @Size(max = 255)
    private String email;

    @Size(max = 255)
    private String password;

    private UserRole userRole;

    private UUID organizationId;



}
