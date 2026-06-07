package com.example.demo.organization.entity.RequestDTOs;

import com.example.demo.common.validation.TunisianTaxId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationCreateDTO {

    @NotBlank
    private String name;

    @NotNull
    @TunisianTaxId
    private String taxId;

    @NotBlank
    private String sector;

}
