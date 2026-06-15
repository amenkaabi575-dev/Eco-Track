package com.example.demo.emissionFactor.entity.requestDTOs;


import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmissionFactorUpdateDTO {

    private String name;

    private EmissionFactorUnit unit;


}
