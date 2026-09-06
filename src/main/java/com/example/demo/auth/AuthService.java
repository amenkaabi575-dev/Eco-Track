package com.example.demo.auth;

import com.example.demo.auth.DTOs.request.LoginRequest;
import com.example.demo.auth.DTOs.request.LoginResponse;
import com.example.demo.auth.security.CustomUserDetails;
import com.example.demo.auth.security.jwt.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;


    public LoginResponse login(LoginRequest loginRequest){

        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getUsername(),loginRequest.getPassword());
        Authentication authenticated = authenticationManager.authenticate(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authenticated.getPrincipal();

        String refreshToken = jwtService.generateRefreshToken(userDetails);
        String accessToken = jwtService.generateAccessToken(userDetails);

        LoginResponse loginResponse = LoginResponse.builder()
                .refreshToken(refreshToken)
                .accessToken(accessToken)
                .build()
                ;

        return loginResponse;

    }

    public String refreshAccessToken(String refreshToken){

        try{
            Claims claims = jwtService.extractClaims(refreshToken);

            if(!JwtService.REFRESH_TOKEN.equals(claims.get(JwtService.TOKEN_TYPE, String.class))){
                throw new JwtException("Incorrect token type");
            }

            String username = claims.getSubject();

            CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);

            return jwtService.generateAccessToken(userDetails);
        }
        catch (UsernameNotFoundException | JwtException | IllegalArgumentException e){
            throw new BadCredentialsException("Unable to refresh access token");
        }

    }


}
