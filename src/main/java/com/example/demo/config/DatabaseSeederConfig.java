package com.example.demo.config;


import com.example.demo.activity.ActivityRepository;
import com.example.demo.activity.entity.Activity;
import com.example.demo.asset.AssetRepository;
import com.example.demo.asset.entity.Asset;
import com.example.demo.asset.entity.AssetType;
import com.example.demo.emissionFactor.EmissionFactorRepository;
import com.example.demo.emissionFactor.entity.EmissionFactor;
import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import com.example.demo.organization.OrganizationRepository;
import com.example.demo.organization.entity.Organization;
import com.example.demo.user.UserRepository;
import com.example.demo.user.enitity.User;
import com.example.demo.user.enitity.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Configuration
public class DatabaseSeederConfig {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   OrganizationRepository organizationRepository,
                                   AssetRepository assetRepository,
                                   EmissionFactorRepository emissionFactorRepository,
                                   ActivityRepository activityRepository,
                                   PasswordEncoder passwordEncoder){

        return args -> {

            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = User.builder()
                        .username("admin")
                        .email("admin@admin.com")
                        .password(passwordEncoder.encode("sasuke123"))
                        .role(UserRole.ADMIN)
                        .createdAt(LocalDateTime.now())
                        .build()
                        ;
                userRepository.save(admin);


                Organization organization = Organization.builder()
                                .name("DemoOrganization")
                                .taxId("000")
                                .sector("Unknown").createdAt(LocalDateTime.now())
                                .createdBy(admin)
                                .build()
                                ;
                organizationRepository.save(organization);

                Asset asset = Asset.builder()
                        .name("DemoAsset")
                        .type(AssetType.OTHER)
                        .description("None")
                        .createdAt(LocalDateTime.now())
                        .organization(organization)
                        .createdBy(admin)
                        .build()
                        ;
                assetRepository.save(asset);

                EmissionFactor emissionFactor = EmissionFactor.builder()
                        .name("DemoFactor")
                        .unit(EmissionFactorUnit.KWH)
                        .factorValue(BigDecimal.valueOf(4.5))
                        .createdAt(LocalDateTime.now())
                        .organization(organization)
                        .createdBy(admin)
                        .build()
                        ;
                emissionFactorRepository.save(emissionFactor);

                Activity activity = Activity.builder()
                        .quantity(BigDecimal.valueOf(500))
                        .consumptionUnit(EmissionFactorUnit.KWH)
                        .activityDate(Instant.now())
                        .recordedAt(Instant.now())
                        .calculatedCo2(BigDecimal.valueOf(1000))
                        .asset(asset)
                        .emissionFactor(emissionFactor)
                        .createdBy(admin)
                        .build()
                        ;
                activityRepository.save(activity);
            }

        };

    }

}
