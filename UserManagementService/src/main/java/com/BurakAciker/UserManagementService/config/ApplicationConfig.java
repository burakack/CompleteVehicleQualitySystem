package com.BurakAciker.UserManagementService.config;


import com.BurakAciker.UserManagementService.dto.RegisterRequest;
import com.BurakAciker.UserManagementService.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AppUserService appUserService;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

            try{
                appUserService.register(new RegisterRequest("adminname", "adminsurname", "toyota",
                        "123toyota123", "toyota@gmail.com"));
                System.out.println("ADMIN User created");
            }catch (Exception e) {

                System.out.println(e.getMessage());
            }
        };
    }
}
