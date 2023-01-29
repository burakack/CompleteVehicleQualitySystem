package com.BurakAciker.UserManagementService.repository;

import com.BurakAciker.UserManagementService.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    /**
     * Verilen rol adına sahip rolü döndürür.
     * @param rolename
     * Rol adı
     * @return Role
     */
    Role findByname(String rolename);
}