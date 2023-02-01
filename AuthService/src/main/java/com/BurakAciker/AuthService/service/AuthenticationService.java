package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.dto.AuthenticationRequest;
import com.BurakAciker.AuthService.dto.AuthenticationResponse;
import com.BurakAciker.AuthService.dto.RegisterRequest;

public interface AuthenticationService {

    /**
     * Checks jwt token and returns Token if it is valid
     * @param request
     * @returns AuthenticationResponse
     */
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
