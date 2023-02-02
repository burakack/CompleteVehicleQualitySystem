package com.BurakAciker.UserManagementService.resource;

import com.BurakAciker.UserManagementService.domain.AppUser;
import com.BurakAciker.UserManagementService.dto.AddRoleToUser;
import com.BurakAciker.UserManagementService.dto.DeleteRequest;
import com.BurakAciker.UserManagementService.dto.RegisterRequest;
import com.BurakAciker.UserManagementService.service.AppUserService;
import com.BurakAciker.UserManagementService.service.RestRequestsService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-management")
public class UserManagementController {
    private final Logger logger = LogManager.getLogger(UserManagementController.class);
    private final RestRequestsService restRequestsService;
    private  final AppUserService appUserService;

    @PostMapping("/add-role-to-user")
    public void addRoleToUser(@RequestBody AddRoleToUser addRoleToUser, @RequestHeader("Authorization") String token){
        logger.info("Add role to user request received parameters:"+addRoleToUser.toString() + " token: " + token);
        restRequestsService.roleCheck("ADMIN", token);
        appUserService.addRoleToUser(addRoleToUser.getUsername(), addRoleToUser.getRoleName());
    }
    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody RegisterRequest registerRequest, @RequestHeader("Authorization") String token){
        logger.info("Add user request received parameters:"+registerRequest.toString() + " token: " + token);
        restRequestsService.roleCheck("ADMIN", token);
        return appUserService.register(registerRequest);
    }
    @DeleteMapping("/delete-user")
    public void deleteUser(@RequestBody DeleteRequest deleteRequest, @RequestHeader("Authorization") String token){
        logger.info("Delete user request received parameters:"+deleteRequest.toString() + " token: " + token);
        restRequestsService.roleCheck("ADMIN", token);
        appUserService.deleteAppUser(deleteRequest.getUsername());
    }
    @PutMapping("/update-user")
    public void updateUser(@RequestBody AppUser appUser, @RequestHeader("Authorization") String token){
        logger.info("Update user request received parameters:"+appUser.toString() + " token: " + token);
        restRequestsService.roleCheck("ADMIN", token);
        appUserService.updateAppUser(appUser);
    }

}


