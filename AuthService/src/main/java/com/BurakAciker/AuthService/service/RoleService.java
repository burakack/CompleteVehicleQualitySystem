package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.domain.Role;

public interface RoleService {

    /**
     * Yeni bir rol oluşturur.
     * @param role
     * Kullanıcı nesnesi
     */
    void createRole(Role role);
    /**
     * Belirli bir ada sahip rolü geri döndürür.
     * @param name
     * Kullanıcı adı
     * @return AppUser
     */
    Role getRoleByName(String name);

    /**
     * Bir rolü siler.
     * @param role
     * Kullanıcı nesnesi
     */
    void deleteRole(Role role);
}
