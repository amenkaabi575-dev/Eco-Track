package com.example.demo.analytics.responseDTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectorEmissionDTO {

    private String sector;

    private BigDecimal totalCo2;

}
