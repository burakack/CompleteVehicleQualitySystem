package com.BurakAciker.AuthService.dao;


import com.BurakAciker.AuthService.domain.AppUser;
import com.BurakAciker.AuthService.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends  JpaRepository<AppUser,Long> {
    /**
     * Verilen Username'e Sahip kullanıcıyı döndürür.
     * @return  AppUser
     */
    AppUser findByUsername(String username);
}
