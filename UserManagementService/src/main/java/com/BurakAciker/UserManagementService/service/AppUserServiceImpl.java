package com.BurakAciker.UserManagementService.service;

import com.BurakAciker.UserManagementService.domain.AppUser;
import com.BurakAciker.UserManagementService.domain.Role;
import com.BurakAciker.UserManagementService.repository.AppUserRepository;
import com.BurakAciker.UserManagementService.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service @RequiredArgsConstructor @Transactional
public class AppUserServiceImpl implements AppUserService {


    private final AppUserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void createAppUser(AppUser appUser) {
    userRepository.save(appUser);
    }

    @Override
    public AppUser getAppUserByUsername(String username) {

        AppUser user=userRepository.findByUsername(username);
        if(user!=null && user.getDeletedAt()!=null )
            return userRepository.findByUsername(username);
        else{
            throw new ArithmeticException("User not found.");
        }
    }

    @Override
    public void deleteAppUser(AppUser appUser) {
        AppUser user=userRepository.findById(appUser.getId()).get();
        user.setDeletedAt(new Date());
    }

    @Override
    public void updateAppUser(AppUser appUser) {
    //Doldur
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user=userRepository.findByUsername(username);
        Role role=roleRepository.findByname(roleName);
        user.getRoles().add(role);
    }
}
