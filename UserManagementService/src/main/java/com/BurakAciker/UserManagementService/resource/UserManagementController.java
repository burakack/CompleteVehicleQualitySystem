package com.BurakAciker.UserManagementService.resource;

import com.BurakAciker.UserManagementService.dto.AddRoleToUser;
import com.BurakAciker.UserManagementService.repository.AppUserRepository;
import com.BurakAciker.UserManagementService.service.AppUserService;
import com.BurakAciker.UserManagementService.service.RestRequestsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class UserManagementController {

    private final RestRequestsService restRequestsService;
    private  final AppUserService appUserService;

    @PostMapping("/add-role-to-user")
    public void addRoleToUser(@RequestBody AddRoleToUser addRoleToUser, @RequestHeader("Authorization") String token){
        restRequestsService.roleCheck("admin", token);
        appUserService.addRoleToUser(addRoleToUser.getUsername(), addRoleToUser.getRoleName());
    }

}


