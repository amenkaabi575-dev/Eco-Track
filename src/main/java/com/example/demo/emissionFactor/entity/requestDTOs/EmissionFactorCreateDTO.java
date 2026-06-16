package com.example.demo.emissionFactor.entity.requestDTOs;

import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class EmissionFactorCreateDTO {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private EmissionFactorUnit unit;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal factorValue;

    @NotNull
    private UUID organizationId;

}
