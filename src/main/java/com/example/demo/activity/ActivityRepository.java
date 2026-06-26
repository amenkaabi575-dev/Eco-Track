package com.example.demo.activity;

import com.example.demo.activity.entity.Activity;
import com.example.demo.activity.entity.responseDTOs.ActivityDTO;
import com.example.demo.analytics.responseDTOs.AssetEmissionDTO;
import com.example.demo.analytics.responseDTOs.MonthlyEmissionDTO;
import com.example.demo.analytics.responseDTOs.SectorEmissionDTO;
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
            AND asset.organization.id = :organizationId
            """)
    List<ActivityDTO> findActivityDTOsByAssetIdAndOrganizationId(UUID assetId, UUID organizationId);


    @Query("""            
            SELECT new com.example.demo.analytics.responseDTOs.AssetEmissionDTO(
            asset.id,
            asset.name,
            COALESCE(SUM(activity.calculatedCo2),0.0)
            )
            FROM Activity activity
            JOIN activity.asset asset
            JOIN asset.organization organization
            WHERE organization.id = :organizationId
            GROUP BY asset.id, asset.name
            """)
    List<AssetEmissionDTO> findAssetEmissionsByOrganizationId(UUID organizationId);


    @Query("""
            SELECT new com.example.demo.analytics.responseDTOs.MonthlyEmissionDTO(
            YEAR(activity.activityDate),
            MONTH(activity.activityDate),
            COALESCE(SUM(activity.calculatedCo2),0.0)
            )
            FROM Activity activity
            JOIN activity.asset asset
            JOIN asset.organization organization
            WHERE organization.id = :organizationId
            GROUP BY YEAR(activity.activityDate), MONTH(activity.activityDate)
            """)
    List<MonthlyEmissionDTO> findMonthlyEmissionsByOrganizationId(UUID organizationId);


    @Query("""
            SELECT new com.example.demo.analytics.responseDTOs.SectorEmissionDTO(
            organization.sector,
            COALESCE(SUM(activity.calculatedCo2),0.0)
            )
            FROM Activity activity
            JOIN activity.asset asset
            JOIN asset.organization organization
            WHERE organization.id = :organizationId
            GROUP BY organization.sector
            """)
    List<SectorEmissionDTO> findSectorEmissionsByOrganizationId(UUID organizationId);

}
