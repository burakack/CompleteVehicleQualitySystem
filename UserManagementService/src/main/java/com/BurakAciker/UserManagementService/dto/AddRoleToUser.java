package com.BurakAciker.UserManagementService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddRoleToUser {
    private String username;
    private String roleName;
}