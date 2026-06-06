package com.example.demo.Organization.Entity.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationUpdateDTO {

    private String name;

    private String taxId;

    private String Sector;

}
