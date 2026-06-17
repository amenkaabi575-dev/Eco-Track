package com.example.demo.activity.entity;


import com.example.demo.activity.ActivityRepository;
import com.example.demo.activity.ActivityService;
import com.example.demo.activity.entity.requestDTOs.ActivityCreateDTO;
import com.example.demo.activity.entity.requestDTOs.ActivityUpdateDTO;
import com.example.demo.activity.entity.responseDTOs.ActivityDTO;
import com.example.demo.asset.AssetRepository;
import com.example.demo.asset.entity.Asset;
import com.example.demo.common.exception.BusinessException;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.emissionFactor.EmissionFactorRepository;
import com.example.demo.emissionFactor.entity.EmissionFactor;
import com.example.demo.organization.OrganizationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final OrganizationRepository organizationRepository;
    private final AssetRepository assetRepository;
    private final EmissionFactorRepository emissionFactorRepository;

    @Override
    public ActivityDTO createActivity(ActivityCreateDTO dto) {
        Asset asset = assetRepository
                .findById(dto.getAssetId())
                .orElseThrow(()-> new ResourceNotFoundException("Asset Not Found","ASSET_NOT_FOUND"));

        EmissionFactor factor = emissionFactorRepository
                .findById(dto.getEmissionFactorId())
                .orElseThrow(()-> new ResourceNotFoundException("Emission factor not found","EMISSION_FACTOR_NOT_FOUND"));

        if(dto.getConsumptionUnit()!=factor.getUnit()){
            throw new BusinessException(
                    "Consumption unit and emission factor unit must be the same",
                    "UNIT_MISMATCH_ERROR",
                    HttpStatus.CONFLICT
            );
        }

        Activity activity = activityMapper.toEntity(dto);
        activity.setAsset(asset);
        activity.setEmissionFactor(factor);

        return activityMapper.toDto(activityRepository.save(activity));
    }

    @Override
    public ActivityDTO getActivityById(UUID id) {
        return activityMapper.toDto(
                activityRepository
                        .findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Activity not found","ACTIVITY_NOT_FOUND"))
        );
    }

    @Override
    public List<ActivityDTO> getAllActivities() {
        return activityRepository.findAllActivityDTOs();
    }

    @Override
    public List<ActivityDTO> getActivitiesByOrganizationId(UUID organizationId) {
        return activityRepository.findActivityDTOsByOrganizationId(organizationId);
    }

    @Override
    public List<ActivityDTO> getActivitiesByAssetId(UUID assetId) {
        return activityRepository.findActivityDTOsByAssetId(assetId);
    }

    @Override
    public List<ActivityDTO> getActivitiesByAssetIdAndOrganizationId(UUID assetId, UUID organizationId) {
        return activityRepository.findActivityDTOsByAssetIdAndOrganizationId(assetId,organizationId);
    }

    @Override
    @Transactional
    public ActivityDTO updateActivityById(UUID id, ActivityUpdateDTO dto) {
        Activity activity = activityRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Activity not found","ACTIVITY_NOT_FOUND"));
        activityMapper.updateActivityFromDto(dto,activity);
        return activityMapper.toDto(activity);
    }

    @Override
    public void deleteActivityById(UUID id) {

        activityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Activity not found","ACTIVITY_NOT_FOUND"));
        activityRepository.deleteById(id);

    }
}
