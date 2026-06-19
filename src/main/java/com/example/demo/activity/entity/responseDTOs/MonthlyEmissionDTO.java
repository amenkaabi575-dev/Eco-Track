package com.example.demo.activity.entity.responseDTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyEmissionDTO {

    private Integer year;

    private Integer Month;

    private BigDecimal totalCo2;


}
