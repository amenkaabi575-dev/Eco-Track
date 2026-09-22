package com.example.demo.emissionFactor.entity.responseDTOs;


import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmissionFactorDTO {

    private UUID id;

    private String name;

    private EmissionFactorUnit unit;

    private BigDecimal factorValue;

    private String organizationName;

}
