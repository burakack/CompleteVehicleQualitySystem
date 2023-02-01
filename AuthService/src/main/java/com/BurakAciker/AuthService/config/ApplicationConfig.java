package com.BurakAciker.AuthService.config;

import com.BurakAciker.AuthService.dao.AppUserRepository;
import com.BurakAciker.AuthService.dao.RoleRepository;
import com.BurakAciker.AuthService.domain.Role;
import com.BurakAciker.AuthService.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final AppUserRepository userRepository;
    private final RoleService roleService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            try {
                roleService.createRole(new Role("ADMIN"));
            } catch (Exception e) {
                System.out.println("ADMIN Role already exists");
            }
            try {
                roleService.createRole(new Role("TEAMLEAD"));
            } catch (Exception e) {
                System.out.println("TEAMLEAD Role already exists");
            }
            try {
                roleService.createRole(new Role("OPERATOR"));
            } catch (Exception e) {
                System.out.println("OPERATOR Role already exists");
            }
        };
    }
}