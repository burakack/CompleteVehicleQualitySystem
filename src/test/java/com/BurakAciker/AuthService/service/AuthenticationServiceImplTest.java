package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.dto.AuthenticationRequest;
import com.BurakAciker.AuthService.dto.AuthenticationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {

    @InjectMocks
    AuthenticationServiceImpl authenticationService;

    @Mock
    AuthenticationManager authenticationManager;

    AuthenticationRequest request;
    AuthenticationResponse expectedResponse;
    Authentication authentication;

    @BeforeEach
    void setUp() {
        request = new AuthenticationRequest("testUser", "testPassword");
        expectedResponse = new AuthenticationResponse("testToken");
        authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
    }

    @Test
    void authenticate() {
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);

        AuthenticationResponse response = authenticationService.authenticate(request);
        assertEquals(expectedResponse.getToken(), response.getToken());
    }

}