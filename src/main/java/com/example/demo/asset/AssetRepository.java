package com.example.demo.asset;

import com.example.demo.asset.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AssetRepository extends JpaRepository<Asset, UUID> {

    List<Asset> findAssetsByOrganizationId(UUID id);

    @Query("""
            SELECT asset FROM Asset asset
            JOIN FETCH asset.organization organization
            """)
    List<Asset> findAllAssets();

}
