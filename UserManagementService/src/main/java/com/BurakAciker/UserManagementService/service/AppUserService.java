package com.BurakAciker.UserManagementService.service;
import com.BurakAciker.UserManagementService.domain.AppUser;

public interface AppUserService {

    /**
     * Yeni bir kullanıcı oluşturur.
     * @param appUser
     * Kullanıcı nesnesi
     */
    void createAppUser(AppUser appUser);
    /**
     * Belirli bir kullanıcı adına sahip kullanıcıyı geri döndürür.
     * @param username
     * Kullanıcı adı
     * @return AppUser
     */
    AppUser getAppUserByUsername(String username);

    /**
     * Bir kullanıcıyı siler.
     * @param appUser
     * Kullanıcı nesnesi
     */
    void deleteAppUser(AppUser appUser);
    /**
     * Bir kullanıcının bilgilerini günceller.
     * @param appUser
     * Kullanıcı nesnesi
     */
    void updateAppUser(AppUser appUser);

    void addRoleToUser(String username, String rolename);
}
