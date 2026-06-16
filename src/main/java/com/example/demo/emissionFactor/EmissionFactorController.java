package com.example.demo.emissionFactor;

import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorCreateDTO;
import com.example.demo.emissionFactor.entity.requestDTOs.EmissionFactorUpdateDTO;
import com.example.demo.emissionFactor.entity.responseDTOs.EmissionFactorDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/emission-factors")
public class EmissionFactorController {

    private final EmissionFactorService emissionFactorService;


    @PostMapping
    public EmissionFactorDTO createEmissionFactor(@RequestBody @Valid EmissionFactorCreateDTO dto){

        return emissionFactorService.createFactor(dto);

    }

    @GetMapping("/{id}")
    public EmissionFactorDTO getEmissionFactorById(@PathVariable UUID id){

        return emissionFactorService.getFactorById(id);

    }

    @GetMapping
    public List<EmissionFactorDTO> getEmissionFactors(@RequestParam(required = false) boolean isGlobal){

        if (isGlobal){
            return emissionFactorService.getGlobalFactors();
        }

        return emissionFactorService.getAllFactors();

    }

    @PutMapping("/{id}")
    public EmissionFactorDTO updateEmissionFactorById(@PathVariable UUID id, @RequestBody @Valid EmissionFactorUpdateDTO dto){

        return emissionFactorService.updateFactorById(id,dto);

    }

    @DeleteMapping("/{id}")
    public void deleteEmissionFactorById(@PathVariable UUID id){

        emissionFactorService.deleteFactorById(id);

    }


}
