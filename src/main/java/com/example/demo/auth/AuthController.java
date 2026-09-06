package com.example.demo.auth;

import com.example.demo.auth.DTOs.login.LoginRequest;
import com.example.demo.auth.DTOs.login.LoginResponse;
import com.example.demo.auth.DTOs.refresh.RefreshTokenRequest;
import com.example.demo.auth.DTOs.refresh.RefreshTokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest){

        return authService.login(loginRequest);

    }

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    public RefreshTokenResponse refreshAccessToken(@Valid @RequestBody RefreshTokenRequest request){

        return authService.refreshAccessToken(request);

    }

}
