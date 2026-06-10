package com.example.demo.organization;

import com.example.demo.organization.entity.RequestDTOs.OrganizationCreateDTO;
import com.example.demo.organization.entity.RequestDTOs.OrganizationUpdateDTO;
import com.example.demo.organization.entity.ResponseDTOs.OrganizationDTO;
import jakarta.validation.Valid;
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
    public OrganizationDTO createOrganization(@Valid @RequestBody OrganizationCreateDTO dto){

        return organizationService.createOrganization(dto);

    }

    @PutMapping("{id}")
    public OrganizationDTO updateOrganizationById(@PathVariable UUID id,
                                             @Valid @RequestBody OrganizationUpdateDTO dto){

        return organizationService.updateOrganizationById(id,dto);

    }

    @DeleteMapping("{id}")
    public void deleteOrganizationById(@PathVariable UUID id){

        organizationService.deleteOrganizationById(id);

    }


}
