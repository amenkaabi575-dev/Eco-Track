package com.example.demo.auth.security.jwt;

import com.example.demo.auth.security.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {



        if (SecurityContextHolder.getContext().getAuthentication()!= null){
            filterChain.doFilter(request,response);
            return;
        }

        String header = request.getHeader(AUTHORIZATION_HEADER);
        if (header == null || !header.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = header.substring(7);

        try {

            Claims claims = jwtService.extractClaims(token);

            if(!JwtService.ACCESS_TOKEN.equals(claims.get(JwtService.TOKEN_TYPE,String.class))){
                throw new MalformedJwtException("Invalid token type");
            }

            String username = claims.getSubject();
            CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );

            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);

        }
        catch (IllegalArgumentException | JwtException | AuthenticationException e){

            authenticationEntryPoint.commence(request,response, new BadCredentialsException("Jwt authorization failed"));
            return;
        }

        filterChain.doFilter(request,response);

    }
}