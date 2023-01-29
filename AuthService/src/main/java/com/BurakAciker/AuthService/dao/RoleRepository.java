package com.BurakAciker.AuthService.dao;

import com.BurakAciker.AuthService.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String roleName);

}
