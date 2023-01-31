package com.BurakAciker.UserManagementService.repository;

import com.BurakAciker.UserManagementService.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    /**
     * Verilen Username'e Sahip kullanıcıyı döndürür.
     * @return  AppUser
     */
    AppUser findByUsername(String username);

    AppUser findByEmail(String email);
}