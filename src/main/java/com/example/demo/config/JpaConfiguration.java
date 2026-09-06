package com.example.demo.config;


import com.example.demo.auth.security.CustomUserDetails;
import com.example.demo.user.UserRepository;
import com.example.demo.user.enitity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    public AuditorAware<User> auditorAware(UserRepository userRepository) {
        return () -> {
            Authentication auth =
                    SecurityContextHolder.getContext().getAuthentication();

            if (auth == null
                    || !auth.isAuthenticated()
                    || "anonymousUser".equals(auth.getPrincipal())) {
                return Optional.empty();
            }

            CustomUserDetails userDetails =
                    (CustomUserDetails) auth.getPrincipal();

            return userRepository.findById(userDetails.getId());
        };
    }

}
