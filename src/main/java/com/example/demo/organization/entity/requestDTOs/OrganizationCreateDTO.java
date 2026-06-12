package com.example.demo.organization.entity.requestDTOs;

import com.example.demo.common.validation.TunisianTaxId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationCreateDTO {

    @NotBlank(message = "Organization name is required")
    @Size(max = 255, message = "Organization name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Tax ID is required")
    @TunisianTaxId
    private String taxId;

    @NotBlank(message = "Sector is required")
    @Size(max = 255, message = "Sector must not exceed 255 characters")
    private String sector;

}
