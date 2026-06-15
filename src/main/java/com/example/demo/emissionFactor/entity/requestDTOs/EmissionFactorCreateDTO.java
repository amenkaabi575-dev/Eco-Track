package com.example.demo.emissionFactor.entity.requestDTOs;

import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private UUID organizationId;

}
