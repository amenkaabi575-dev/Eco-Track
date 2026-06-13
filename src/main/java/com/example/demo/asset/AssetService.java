package com.example.demo.asset;

import com.example.demo.asset.entity.requestDTOs.AssetCreateDTO;
import com.example.demo.asset.entity.requestDTOs.AssetUpdateDTO;
import com.example.demo.asset.entity.responseDTOs.AssetDTO;

import java.util.List;
import java.util.UUID;

public interface AssetService {


    AssetDTO createAsset(AssetCreateDTO dto);

    AssetDTO getAssetById(UUID id);

    List<AssetDTO> getAllAssets();

    List<AssetDTO> getAssetsByOrganizationId(UUID id);

    AssetDTO updateAssetById(UUID id, AssetUpdateDTO dto);

    void deleteAssetById(UUID id);


}
