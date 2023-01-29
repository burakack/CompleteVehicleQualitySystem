package com.BurakAciker.UserManagementService.service;
import com.BurakAciker.UserManagementService.domain.AppUser;
import com.BurakAciker.UserManagementService.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AppUserService {

    /**
     * Yeni bir kullanıcı oluşturur.
     * @param request
     * Kullanıcı bilgileri
     * @return ResponseEntity
     */
    public ResponseEntity<String> register(RegisterRequest request);

    /**
     * Belirli bir kullanıcı adına sahip kullanıcıyı geri döndürür.
     * @param username
     * Kullanıcı adı
     * @return AppUser
     */
    AppUser getAppUserByUsername(String username);

    /**
     * Bir kullanıcıyı siler.
     * @param username
     * Kullanıcı nesnesi
     */
    void deleteAppUser(String username);

    /**
     * Bir kullanıcının bilgilerini günceller.
     * @param appUser
     * Kullanıcı nesnesi
     */
    void updateAppUser(AppUser appUser);

    void addRoleToUser(String username, String rolename);
}
