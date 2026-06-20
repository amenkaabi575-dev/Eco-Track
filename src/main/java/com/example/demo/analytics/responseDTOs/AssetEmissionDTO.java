package com.example.demo.analytics.responseDTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetEmissionDTO {


    private UUID assetId;
    private String assetName;
    private BigDecimal totalCO2;

}
