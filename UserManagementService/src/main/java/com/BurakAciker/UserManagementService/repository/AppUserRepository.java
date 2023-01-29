package com.BurakAciker.UserManagementService.repository;

import com.BurakAciker.UserManagementService.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    /**
     * Verilen Username'e Sahip kullanıcıyı döndürür.
     * @return  AppUser
     */
    AppUser findByUsername(String username);
}