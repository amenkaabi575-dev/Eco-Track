package com.example.demo.asset;


import com.example.demo.asset.entity.requestDTOs.AssetCreateDTO;
import com.example.demo.asset.entity.requestDTOs.AssetUpdateDTO;
import com.example.demo.asset.entity.responseDTOs.AssetDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ap1/v1/assets")
public class AssetController {

    private final AssetService assetService;


    @GetMapping
    public List<AssetDTO> getAssets(@RequestParam(required = false) UUID organizationId){

        if (organizationId == null){
            return assetService.getAllAssets();
        }

        return assetService.getAssetsByOrganizationId(organizationId);

    }

    @GetMapping("/{id}")
    public AssetDTO getAssetById(@PathVariable UUID id){

        return assetService.getAssetById(id);

    }

    @PostMapping
    public AssetDTO createAsset(@RequestBody @Valid AssetCreateDTO dto){

        return assetService.createAsset(dto);

    }

    @PutMapping("/{id}")
    public AssetDTO updateAssetById(@PathVariable UUID id, @RequestBody @Valid AssetUpdateDTO dto){

        return assetService.updateAssetById(id,dto);

    }


    @DeleteMapping("/{id}")
    public void deleteAssetById(@PathVariable UUID id){

        assetService.deleteAssetById(id);

    }

}
