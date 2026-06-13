package com.example.demo.asset;


import com.example.demo.asset.entity.Asset;
import com.example.demo.asset.entity.AssetMapper;
import com.example.demo.asset.entity.requestDTOs.AssetCreateDTO;
import com.example.demo.asset.entity.requestDTOs.AssetUpdateDTO;
import com.example.demo.asset.entity.responseDTOs.AssetDTO;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.organization.OrganizationRepository;
import com.example.demo.organization.entity.Organization;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;
    private final OrganizationRepository organizationRepository;
    private final AssetMapper assetMapper;

    @Override
    public AssetDTO createAsset(AssetCreateDTO dto) {
        Organization organization = organizationRepository
                .findById(dto.getOrganizationId())
                .orElseThrow(()-> new ResourceNotFoundException("Organization not found","ORGANIZATION_NOT_FOUND"));

        Asset asset = assetMapper.toEntity(dto);
        asset.setOrganization(organization);
        return assetMapper.toDto(assetRepository.save(asset));

    }

    @Override
    @Transactional
    public AssetDTO getAssetById(UUID id) {
        Asset asset = assetRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Asset not found","ASSET_NOT_FOUND"));

        return assetMapper.toDto(asset);
    }

    @Override
    public List<AssetDTO> getAllAssets() {
        return assetRepository
                .findAllAssets()
                .stream()
                .map(assetMapper::toDto).toList();
    }

    @Override
    public List<AssetDTO> getAssetsByOrganizationId(UUID id) {
        return assetRepository.findAssetsByOrganizationId(id).stream().map(assetMapper::toDto).toList();
    }

    @Override
    @Transactional
    public AssetDTO updateAssetById(UUID id, AssetUpdateDTO dto) {
        Asset asset = assetRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Asset not found","ASSET_NOT_FOUND"));

        assetMapper.updateEntityFromDto(dto,asset);
        return assetMapper.toDto(asset);
    }

    @Override
    public void deleteAssetById(UUID id) {

        Asset asset = assetRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Asset not found","ASSET_NOT_FOUND"));

        assetRepository.delete(asset);

    }
}
