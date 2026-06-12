package com.example.demo.user.enitity.responseDTOs;


import com.example.demo.user.enitity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String username;

    private String email;

    private UserRole userRole;

    private UUID organizationId;

    private LocalDateTime createdAt;

}
