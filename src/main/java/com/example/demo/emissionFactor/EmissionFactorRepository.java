package com.example.demo.emissionFactor;

import com.example.demo.emissionFactor.entity.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, UUID> {



    @Query("""
            SELECT ef FROM EmissionFactor ef
            WHERE ef.organization IS NULL
            """)
    List<EmissionFactor> findByIsGlobalTrue();

    boolean existsByName(String name);

    @Query("""
            SELECT ef FROM EmissionFactor ef
            LEFT JOIN FETCH ef.organization o
            """)
    List<EmissionFactor> findAllFactors();

}
