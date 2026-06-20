package com.example.demo.analytics;

import com.example.demo.analytics.responseDTOs.AssetEmissionDTO;
import com.example.demo.analytics.responseDTOs.MonthlyEmissionDTO;
import com.example.demo.analytics.responseDTOs.SectorEmissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/assets/{organizationId}")
    public List<AssetEmissionDTO> getEmissionsByAsset(@PathVariable(name = "organizationId") UUID id){

        return analyticsService.getEmissionsByAsset(id);

    }

    @GetMapping("/monthly/{organizationId}")
    public List<MonthlyEmissionDTO> getMonthlyEmissions(@PathVariable(name = "organizationId") UUID id){

        return analyticsService.getMonthlyEmissions(id);

    }

    @GetMapping("/sector/{organizationId}")
    public List<SectorEmissionDTO> getSectorEmissions(@PathVariable(name = "organizationId") UUID id){

        return analyticsService.getSectorEmissions(id);

    }

}
