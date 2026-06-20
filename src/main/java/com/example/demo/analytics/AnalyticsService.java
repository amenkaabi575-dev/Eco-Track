package com.example.demo.analytics;

import com.example.demo.analytics.responseDTOs.AssetEmissionDTO;
import com.example.demo.analytics.responseDTOs.MonthlyEmissionDTO;
import com.example.demo.analytics.responseDTOs.SectorEmissionDTO;

import java.util.List;
import java.util.UUID;

public interface AnalyticsService {

    List<AssetEmissionDTO> getEmissionsByAsset(UUID organizationId);

    List<MonthlyEmissionDTO> getMonthlyEmissions(UUID organizationId);

    List<SectorEmissionDTO> getSectorEmissions(UUID organizationId);

}
