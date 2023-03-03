package com.BurakAciker.UserManagementService.service;

import com.BurakAciker.UserManagementService.domain.AppUser;
import com.BurakAciker.UserManagementService.domain.Role;
import com.BurakAciker.UserManagementService.dto.RegisterRequest;
import com.BurakAciker.UserManagementService.repository.AppUserRepository;
import com.BurakAciker.UserManagementService.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AppUserServiceImplTest {
    private  AppUserRepository userRepository;
    private  RoleRepository roleRepository;
    private AppUserService appUserService;
    @BeforeEach
    void setUp() {
        userRepository=mock(AppUserRepository.class);
        roleRepository=mock(RoleRepository.class);
        appUserService= new AppUserServiceImpl(userRepository,roleRepository);
    }

    @Test
    void registerWithValidParameters() {
        RegisterRequest request=new RegisterRequest("burak","açıker", "burakack", "abc", "burak_ack@hotmail.com");
        AppUser user=new AppUser("burak_ack@hotmail.com","burakack", "burak", "açıker", "abc");
        when(userRepository.findByUsername("burak")).thenReturn(null);
        when(userRepository.findByEmail("burak_ack@hotmail.com")).thenReturn(null);
        assertDoesNotThrow(()->appUserService.register(request));
        Mockito.verify(userRepository).findByUsername("burakack");
        Mockito.verify(userRepository).findByEmail("burak_ack@hotmail.com");
    }

    @Test
    void getAppUserByUsernameWithValidParameters() {
        when(userRepository.findByUsername("burak")).thenReturn(null);
        assertThrowsExactly(ArithmeticException.class,(()->appUserService.getAppUserByUsername("burak")));
        Mockito.verify(userRepository).findByUsername("burak");
    }
    @Test
    void getAppUserByUsernameWithNotValidParameters() {
        AppUser user=new AppUser();
        user.setDeletedAt(new Date());
        when(userRepository.findByUsername("burakack")).thenReturn(null);
        assertThrowsExactly(ArithmeticException.class,(()->appUserService.getAppUserByUsername("burakack")));
        Mockito.verify(userRepository).findByUsername("burakack");
    }


    @Test
    void updateAppUser() {
        AppUser user=new AppUser();
        user.setId(1L);
        user.setName("a");
        user.setEmail("a");
        user.setUsername("a");
        user.setPassword("a");
        user.setSurname("a");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        assertDoesNotThrow(()->appUserService.updateAppUser(user));
        Mockito.verify(userRepository).findById(1L);
    }

    @Test
    void addRoleToUser() {
        when(userRepository.findByUsername("a")).thenReturn(new AppUser());
        when(roleRepository.findByname("a")).thenReturn(new Role("admin"));
        assertDoesNotThrow(()->appUserService.addRoleToUser("a","admin"));
        Mockito.verify(userRepository).findByUsername("a");
        Mockito.verify(roleRepository).findByname("admin");
    }
}