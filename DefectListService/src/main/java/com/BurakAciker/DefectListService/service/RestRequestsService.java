package com.BurakAciker.DefectListService.service;

public interface RestRequestsService {

    /**
     * Bir kullanıcı sorgulanan rolüne sahip mi diye kontrol eder.
     * @param role
     * @param token
     * @return String
     */
    String roleCheck(String role, String token);

}
