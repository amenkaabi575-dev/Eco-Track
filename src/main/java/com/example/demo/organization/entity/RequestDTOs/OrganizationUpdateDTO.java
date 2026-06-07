package com.example.demo.organization.entity.RequestDTOs;

import com.example.demo.common.validation.TunisianTaxId;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationUpdateDTO {

    @Size(max = 255, message = "Organization name must not exceed 255 characters")
    private String name;

    @Size(max = 255, message = "Sector must not exceed 255 characters")
    private String Sector;

}
