package com.BurakAciker.UserManagementService.service;

import com.BurakAciker.UserManagementService.domain.AppUser;
import com.BurakAciker.UserManagementService.domain.Role;
import com.BurakAciker.UserManagementService.dto.RegisterRequest;
import com.BurakAciker.UserManagementService.repository.AppUserRepository;
import com.BurakAciker.UserManagementService.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service @RequiredArgsConstructor @Transactional
public class AppUserServiceImpl implements AppUserService {

    private final Logger logger = LogManager.getLogger(AppUserServiceImpl.class);
    private final AppUserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public ResponseEntity<String> register(RegisterRequest request) {
        logger.info("Registering user:"+request.toString());

        if(userRepository.findByUsername(request.getUsername())!=null) {
            logger.info("Username already exists.");
        }
        else if(userRepository.findByEmail(request.getEmail())!=null) {
            logger.info("Email already exists.");
        }
        else{
            var user = AppUser.builder()
                    .name(request.getName())
                    .surname(request.getSurname())
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(  new BCryptPasswordEncoder().encode(request.getPassword()))
                    .build();
            userRepository.save(user);
            logger.info("User created successfully.");
            return ResponseEntity.ok("User created successfully.");
        }
        return ResponseEntity.badRequest().body("User could not be created.");
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        logger.info("Getting user by username:"+username);
        AppUser user=userRepository.findByUsername(username);
        if(user!=null && user.getDeletedAt()!=null ) {
            logger.info("User found successfully.");
            return user;
        }
        else{
            logger.error("User not found.");
            throw new ArithmeticException("User not found.");
        }
    }

    @Override
    public void deleteAppUser(String username) {
        logger.info("Deleting user by username:"+username);
        AppUser user=userRepository.findById(userRepository.findByUsername(username).getId()).get();
        user.setDeletedAt(new Date());
    }

    @Override
    public void updateAppUser(AppUser appUser) {
        logger.info("Updating user by username:"+appUser.getUsername());
        AppUser user=userRepository.findById(appUser.getId()).get();
        user.setName(appUser.getName());
        user.setSurname(appUser.getSurname());
        user.setUsername(appUser.getUsername());
        user.setEmail(appUser.getEmail());
        user.setPassword( new BCryptPasswordEncoder().encode(appUser.getPassword()));
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        logger.info("Adding role to user by username:"+username);
        AppUser user=userRepository.findByUsername(username);
        Role role=roleRepository.findByname(roleName);
        user.getRoles().add(role);
    }
}
