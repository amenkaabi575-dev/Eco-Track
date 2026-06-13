package com.example.demo.asset.entity.responseDTOs;

import com.example.demo.asset.entity.AssetType;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Builder
@RequiredArgsConstructor
public class AssetDTO {

    private String name;

    private AssetType type;

    private String description;

    private UUID organizationId;

}
