package com.BurakAciker.UserManagementService.service;

import com.BurakAciker.UserManagementService.dto.AddRoleToUser;
import org.springframework.stereotype.Service;


public interface RestRequestsService {

    /**
     * Bir kullanıcı sorgulanan rolüne sahip mi diye kontrol eder.
     * @param role
     * @param token
     * @return String
     */
    String roleCheck(String role, String token);

}
