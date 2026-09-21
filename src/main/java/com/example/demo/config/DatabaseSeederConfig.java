package com.example.demo.config;


import com.example.demo.user.UserRepository;
import com.example.demo.user.enitity.User;
import com.example.demo.user.enitity.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.time.LocalDateTime;

@Configuration
public class DatabaseSeederConfig {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder){

        return args -> {

            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = User.builder()
                        .username("admin")
                        .email("admin@admin.com")
                        .password("sasuke123")
                        .role(UserRole.ADMIN)
                        .createdAt(LocalDateTime.now())
                        .build()
                        ;
                userRepository.save(admin);
            }

        };

    }

}
