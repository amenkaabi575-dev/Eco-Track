package com.example.demo.activity.entity.responseDTOs;


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
public class ActivityDTO {

    private UUID assetId;

    private String assetName;

    private UUID emissionFactorId;

    private String emissionFactorName;

    private LocalDateTime activityDate;

    private BigDecimal calculatedCo2;

}
