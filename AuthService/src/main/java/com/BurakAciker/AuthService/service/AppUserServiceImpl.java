package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.dao.AppUserRepository;
import com.BurakAciker.AuthService.dao.RoleRepository;
import com.BurakAciker.AuthService.domain.AppUser;
import com.BurakAciker.AuthService.domain.Role;
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
        Role role=roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }
}
