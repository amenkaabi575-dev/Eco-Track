package com.example.demo.emissionFactor;

import com.example.demo.emissionFactor.entity.EmissionFactor;
import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmissionFactorSeeder implements CommandLineRunner {

    private final EmissionFactorRepository emissionFactorRepository;

    @Override
    public void run(String... args) {

        if (emissionFactorRepository.count() > 0) return;


        emissionFactorRepository.saveAll(List.of(
                EmissionFactor.builder()
                        .name("Diesel")
                        .factorValue(new BigDecimal("2.68"))
                        .unit(EmissionFactorUnit.L)
                        .build(),

                EmissionFactor.builder()
                        .name("Petrol")
                        .factorValue(new BigDecimal("2.31"))
                        .unit(EmissionFactorUnit.L)
                        .build(),

                EmissionFactor.builder()
                        .name("Natural Gas")
                        .factorValue(new BigDecimal("2.04"))
                        .unit(EmissionFactorUnit.M3)
                        .build(),

                EmissionFactor.builder()
                        .name("Electricity")
                        .factorValue(new BigDecimal("0.45"))
                        .unit(EmissionFactorUnit.KWH)
                        .build()
        ));
    }
}