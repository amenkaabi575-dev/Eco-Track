package com.example.demo.Organization.Entity.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationCreateUpdateDTO {

    private String name;

    private String taxId;

    private String sector;

}
