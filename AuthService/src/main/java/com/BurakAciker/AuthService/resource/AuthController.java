package com.BurakAciker.AuthService.resource;

import com.BurakAciker.AuthService.dto.AuthenticationRequest;
import com.BurakAciker.AuthService.dto.AuthenticationResponse;
import com.BurakAciker.AuthService.dto.RegisterRequest;
import com.BurakAciker.AuthService.service.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController{
    private final AuthenticationServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/isADMIN")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AuthenticationResponse> isAdmin(
    ) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/isOPERATOR")
    @PreAuthorize("hasAuthority('OPERATOR')")
    public ResponseEntity<AuthenticationResponse> isOperator(
    ) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/isTEAMLEAD")
    @PreAuthorize("hasAuthority('TEAMLEAD')")
    public ResponseEntity<AuthenticationResponse> isTeamLead(
    ) {
        return ResponseEntity.ok().build();
    }



}