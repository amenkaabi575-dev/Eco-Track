package com.example.demo.activity;


import com.example.demo.activity.entity.requestDTOs.ActivityCreateDTO;
import com.example.demo.activity.entity.requestDTOs.ActivityUpdateDTO;
import com.example.demo.activity.entity.responseDTOs.ActivityDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/activities")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ActivityDTO createActivity(@RequestBody @Valid ActivityCreateDTO dto){

        return activityService.createActivity(dto);

    }

    @GetMapping
    public List<ActivityDTO> getActivities(@RequestParam UUID assetId, @RequestParam UUID organizationId){

        if (assetId != null && organizationId != null){

            return activityService.getActivitiesByAssetIdAndOrganizationId(assetId,organizationId);

        }

        if (assetId!=null){

            return activityService.getActivitiesByAssetId(assetId);

        }

        if (organizationId!= null){

            return activityService.getActivitiesByOrganizationId(organizationId);

        }

        return activityService.getAllActivities();

    }

    @GetMapping("/{id}")
    public ActivityDTO getActivityById(@PathVariable UUID id){

        return activityService.getActivityById(id);

    }

    @PutMapping("/{id}")
    public ActivityDTO updateActivityById(@PathVariable UUID id, @RequestBody @Valid ActivityUpdateDTO dto){

        return activityService.updateActivityById(id,dto);

    }

    @DeleteMapping("/{id}")
    public void deleteActivityById(@PathVariable UUID id){

        activityService.deleteActivityById(id);

    }


}
