package com.example.demo.activity;

import com.example.demo.activity.entity.Activity;
import com.example.demo.activity.entity.responseDTOs.ActivityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {


    @Query("""
            
            SELECT new com.example.demo.activity.entity.responseDTOs.ActivityDTO(
            asset.id,
            asset.name,
            emissionFactor.id,
            emissionFactor.name,
            activity.activityDate,
            activity.calculatedCo2
            )
            FROM Activity activity
            JOIN activity.asset asset
            JOIN activity.emissionFactor emissionFactor
            """)
    List<ActivityDTO> findAllActivityDTOs();

    @Query("""
            
            SELECT new com.example.demo.activity.entity.responseDTOs.ActivityDTO(
            asset.id,
            asset.name,
            emissionFactor.id,
            emissionFactor.name,
            activity.activityDate,
            activity.calculatedCo2
            )
            FROM Activity activity
            JOIN activity.asset asset
            JOIN activity.emissionFactor emissionFactor
            WHERE asset.organization.id = :organizationId
            """)
    List<ActivityDTO> findActivityDTOsByOrganizationId(UUID organizationId);

    @Query("""
            
            SELECT new com.example.demo.activity.entity.responseDTOs.ActivityDTO(
            asset.id,
            asset.name,
            emissionFactor.id,
            emissionFactor.name,
            activity.activityDate,
            activity.calculatedCo2
            )
            FROM Activity activity
            JOIN activity.asset asset
            JOIN activity.emissionFactor emissionFactor
            WHERE asset.id = :assetId
            """)
    List<ActivityDTO> findActivityDTOsByAssetId(UUID assetId);


}
