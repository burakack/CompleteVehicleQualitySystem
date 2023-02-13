package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.dao.AppUserRepository;
import com.BurakAciker.AuthService.domain.AppUser;
import com.BurakAciker.AuthService.dto.AuthenticationRequest;
import com.BurakAciker.AuthService.dto.AuthenticationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationServiceTest {


    private AuthenticationService authenticationService;
    private AuthenticationManager authenticationManager;
    private AppUserRepository repository;
    private jwtTokenService jwtService;

    @BeforeEach
    void setUp() {
        authenticationManager= mock(AuthenticationManager.class);
        repository= mock(AppUserRepository.class);
        jwtService =mock(jwtTokenService.class);
        authenticationService = new AuthenticationServiceImpl(repository, jwtService, authenticationManager);

    }

    @Test
    void whenAuthRequestIsValid() {
        AuthenticationRequest request = new AuthenticationRequest("toyota","123toyota123");
        when(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        )).thenReturn(null);
        when(repository.findByUsername(request.getUsername())).thenReturn(null);
        when(jwtService.generateToken(null)).thenReturn("testtoken");
        Assertions.assertEquals("testtoken", authenticationService.authenticate(request).getToken());

    }    @Test
    void whenAuthRequestIsNotValid() {
        AuthenticationRequest request = new AuthenticationRequest("toyota","drgrsd");
        when(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        )).thenThrow(new RuntimeException("Invalid username or password"));
        Assertions.assertThrows(RuntimeException.class, () -> authenticationService.authenticate(request));
        Mockito.verify(authenticationManager).authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                ) );
    }
}