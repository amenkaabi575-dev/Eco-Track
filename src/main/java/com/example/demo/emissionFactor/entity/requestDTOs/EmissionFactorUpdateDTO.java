package com.example.demo.emissionFactor.entity.requestDTOs;


import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmissionFactorUpdateDTO {

    @Size(max = 255)
    private String name;

    private EmissionFactorUnit unit;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal factorValue;


}
