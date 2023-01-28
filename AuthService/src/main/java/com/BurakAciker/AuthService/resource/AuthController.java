package com.BurakAciker.AuthService.resource;

import com.BurakAciker.AuthService.domain.Role;
import com.BurakAciker.AuthService.dto.AuthenticationRequest;
import com.BurakAciker.AuthService.dto.AuthenticationResponse;
import com.BurakAciker.AuthService.dto.RegisterRequest;
import com.BurakAciker.AuthService.service.AppUserService;
import com.BurakAciker.AuthService.service.AuthenticationServiceImpl;
import com.BurakAciker.AuthService.service.RoleService;
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
    private  final RoleService roleService;
    private  final AppUserService appUserService;
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
    @PostMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AuthenticationResponse> test(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/isadmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AuthenticationResponse> isAdmin(
    ) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/isoperator")
    @PreAuthorize("hasAuthority('OPERATOR')")
    public ResponseEntity<AuthenticationResponse> isOperator(
    ) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/isteamlead")
    @PreAuthorize("hasAuthority('TEAMLEAD')")
    public ResponseEntity<AuthenticationResponse> isTeamLead(
    ) {
        return ResponseEntity.ok().build();
    }



}