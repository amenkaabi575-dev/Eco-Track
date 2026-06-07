package com.example.demo.organization.entity.ResponseDTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {

    private String organizationId;

    private String name;

    private String taxId;

    private String sector;

    private String createdAt;

}
