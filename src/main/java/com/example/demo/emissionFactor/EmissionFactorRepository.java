package com.example.demo.emissionFactor;

import com.example.demo.emissionFactor.entity.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, UUID> {


    List<EmissionFactor> findByIsGlobalTrue();

    boolean existsByName(String name);

}
