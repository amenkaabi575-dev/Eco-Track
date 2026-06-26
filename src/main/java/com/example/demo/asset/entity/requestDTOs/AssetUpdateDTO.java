package com.example.demo.asset.entity.requestDTOs;

import com.example.demo.asset.entity.AssetType;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetUpdateDTO {

    @Size(max = 255)
    private String name;

    private AssetType type;

    @Size(max = 255)
    private String description;

}
