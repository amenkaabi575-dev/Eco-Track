package com.example.demo.activity.entity.requestDTOs;


import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityCreateDTO {

    @NotNull
    private BigDecimal quantity;

    @NotNull
    private EmissionFactorUnit consumptionUnit;

    @NotNull
    private LocalDateTime activityDate;

    @NotNull
    private UUID assetId;

    @NotNull
    private UUID emissionFactorId;



}
