package com.example.demo.activity.entity.requestDTOs;


import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityUpdateDTO {

    private BigDecimal quantity;

    private LocalDateTime activityDate;

}
