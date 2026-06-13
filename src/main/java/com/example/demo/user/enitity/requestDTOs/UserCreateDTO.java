package com.example.demo.user.enitity.requestDTOs;


import com.example.demo.common.validation.Password;
import com.example.demo.user.enitity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDTO {

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    @Password
    private String password;

    @NotNull
    private UserRole userRole;

    private UUID organizationId;

}
