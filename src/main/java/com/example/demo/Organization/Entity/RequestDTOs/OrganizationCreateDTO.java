package com.example.demo.Organization.Entity.RequestDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationCreateDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String taxId;

    @NotBlank
    private String sector;

}
