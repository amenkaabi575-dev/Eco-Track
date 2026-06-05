package com.example.demo.Organization;

import com.example.demo.Organization.Entity.RequestDTOs.OrganizationCreateUpdateDTO;
import com.example.demo.Organization.Entity.ResponseDTOs.OrganizationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/organizations")
public class OrganizationController {


    private final OrganizationService organizationService;

    @GetMapping
    public List<OrganizationDTO> getAllOrganizations(){

        return organizationService.getAllOrganizations();

    }

    @GetMapping("{id}")
    public OrganizationDTO getOrganizationById(@PathVariable UUID id){

        return organizationService.getOrganizationById(id);

    }


    @PostMapping
    public OrganizationDTO createOrganization(@RequestBody OrganizationCreateUpdateDTO dto){

        return organizationService.createOrganization(dto);

    }

    @PutMapping("{id}")
    public OrganizationDTO updateOrganizationById(@PathVariable UUID id,
                                              @RequestBody OrganizationCreateUpdateDTO dto){

        return organizationService.updateOrganizationById(id,dto);

    }

    @DeleteMapping("{id}")
    public void deleteOrganizationById(@PathVariable UUID id){

        organizationService.deleteOrganizationById(id);

    }


}
