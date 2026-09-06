package com.example.demo.auth.DTOs.request;

import com.example.demo.common.validation.Password;
import com.example.demo.common.validation.Username;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @Username
    @Size(min = 6,max = 25, message = "Username must have at least 6 characters and at most 25 characters")
    @NotNull
    private String username;

    @Password
    @NotBlank
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

}
