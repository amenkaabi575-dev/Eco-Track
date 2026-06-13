package com.example.demo.asset.entity.requestDTOs;


import com.example.demo.asset.entity.AssetType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@Builder
public class AssetCreateDTO {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private AssetType type;

    @Size(max = 255)
    private String description;

    @NotNull
    private UUID organizationId;


}
