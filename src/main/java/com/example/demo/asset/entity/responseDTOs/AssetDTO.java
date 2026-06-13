package com.example.demo.asset.entity.responseDTOs;

import com.example.demo.asset.entity.AssetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetDTO {

    private String name;

    private AssetType type;

    private String description;

    private UUID organizationId;

}
