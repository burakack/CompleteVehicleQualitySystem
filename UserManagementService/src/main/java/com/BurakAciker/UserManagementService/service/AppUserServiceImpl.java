package com.BurakAciker.UserManagementService.service;

import com.BurakAciker.UserManagementService.domain.AppUser;
import com.BurakAciker.UserManagementService.domain.Role;
import com.BurakAciker.UserManagementService.dto.RegisterRequest;
import com.BurakAciker.UserManagementService.repository.AppUserRepository;
import com.BurakAciker.UserManagementService.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service @RequiredArgsConstructor @Transactional
public class AppUserServiceImpl implements AppUserService {


    private final AppUserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<String> register(RegisterRequest request) {
        var user = AppUser.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully.");
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
    public void deleteAppUser(String username) {
        AppUser user=userRepository.findById(userRepository.findByUsername(username).getId()).get();
        user.setDeletedAt(new Date());
    }

    @Override
    public void updateAppUser(AppUser appUser) {
        AppUser user=userRepository.findById(appUser.getId()).get();
        user.setName(appUser.getName());
        user.setSurname(appUser.getSurname());
        user.setUsername(appUser.getUsername());
        user.setEmail(appUser.getEmail());
        user.setPassword(passwordEncoder.encode(appUser.getPassword()));
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user=userRepository.findByUsername(username);
        Role role=roleRepository.findByname(roleName);
        user.getRoles().add(role);
    }
}
