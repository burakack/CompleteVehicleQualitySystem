package com.BurakAciker.UserManagementService.service;

import com.BurakAciker.UserManagementService.dto.AddRoleToUser;
import org.springframework.stereotype.Service;


public interface RestRequestsService {

    String roleCheck(String role, String token);

}
