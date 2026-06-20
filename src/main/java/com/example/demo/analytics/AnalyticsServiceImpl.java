package com.example.demo.analytics;

import com.example.demo.activity.ActivityRepository;
import com.example.demo.analytics.responseDTOs.AssetEmissionDTO;
import com.example.demo.analytics.responseDTOs.MonthlyEmissionDTO;
import com.example.demo.analytics.responseDTOs.SectorEmissionDTO;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.organization.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final OrganizationRepository organizationRepository;
    private final ActivityRepository activityRepository;


    @Override
    public List<AssetEmissionDTO> getEmissionsByAsset(UUID organizationId) {
        organizationRepository
                .findById(organizationId)
                .orElseThrow(()-> new ResourceNotFoundException("Organization not found", "ORGANIZATION_NOT_FOUND"));
        return activityRepository.findAssetEmissionsByOrganizationId(organizationId);
    }

    @Override
    public List<MonthlyEmissionDTO> getMonthlyEmissions(UUID organizationId) {
        organizationRepository
                .findById(organizationId)
                .orElseThrow(()-> new ResourceNotFoundException("organization not found","ORGANIZATION_NOT_FOUND"));
        return activityRepository.findMonthlyEmissionsByOrganizationId(organizationId);
    }

    @Override
    public List<SectorEmissionDTO> getSectorEmissions(UUID organizationId) {
        organizationRepository
                .findById(organizationId)
                .orElseThrow(()-> new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));
        return activityRepository.findSectorEmissionsByOrganizationId(organizationId);
    }
}
