package com.example.demo.organization.entity.RequestDTOs;

import com.example.demo.common.validation.TunisianTaxId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationUpdateDTO {

    private String name;

    @TunisianTaxId
    private String taxId;

    private String Sector;

}
