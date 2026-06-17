package com.example.demo.activity;

import com.example.demo.activity.entity.requestDTOs.ActivityCreateDTO;
import com.example.demo.activity.entity.requestDTOs.ActivityUpdateDTO;
import com.example.demo.activity.entity.responseDTOs.ActivityDTO;

import java.util.List;
import java.util.UUID;

public interface ActivityService {

    ActivityDTO createActivity(ActivityCreateDTO dto);

    ActivityDTO getActivityById(UUID id);

    List<ActivityDTO> getAllActivities();

    List<ActivityDTO> getActivitiesByOrganizationId(UUID id);

    List<ActivityDTO> getActivitiesByAssetId(UUID id);

    ActivityDTO updateActivityById(UUID id, ActivityUpdateDTO dto);

    void deleteActivityById(UUID id);

}
