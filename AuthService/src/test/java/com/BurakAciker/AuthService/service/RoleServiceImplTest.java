package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.dao.AppUserRepository;
import com.BurakAciker.AuthService.dao.RoleRepository;
import com.BurakAciker.AuthService.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoleServiceImplTest {

    private RoleRepository repository;
    private RoleService roleService;

    @BeforeEach
    public void setUp() {
        repository = mock(RoleRepository.class);
        roleService = new RoleServiceImpl(repository);
    }

    @Test
    public void createRolewithValidRequest() {
        Role role= new Role("erfdhfdh");
        when(repository.save(role)).thenReturn(null);
        when(repository.findByName(role.getName())).thenReturn(null);
        assertDoesNotThrow(()->roleService.createRole(role));
        Mockito.verify(repository).save(role);
        Mockito.verify(repository).findByName(role.getName());

    }
    @Test
    public void createRolewithNotValidRequest() {
        Role role= new Role("ADMIN");
        when(repository.save(role)).thenReturn(role);
        when(repository.findByName(role.getName())).thenReturn(new Role ("ADMIN"));

        assertThrowsExactly(RuntimeException.class,()->roleService.createRole(role));
    }
    @Test void getRoleByNameWithValidRequest(){
        Role role= new Role("ADMIN");
        when(repository.findByName(role.getName())).thenReturn(role);
        assertEquals(role,roleService.getRoleByName(role.getName()));
        Mockito.verify(repository).findByName(role.getName());
    }
    @Test void getRoleByNameWithNotValidRequest(){
        Role role= new Role("ADMIN");
        when(repository.findByName(role.getName())).thenReturn(new Role("ADMIN",new Date(),new Date(),new Date()));
        assertNotEquals(role,roleService.getRoleByName(role.getName()));
        Mockito.verify(repository).findByName(role.getName());
    }
    @Test void deleteRoleWithValidRequest(){
        Role role= new Role("ADMIN");
        when(repository.findByName(role.getName())).thenReturn(new Role("ADMIN",new Date(),new Date(),null));
        when(repository.save(role)).thenReturn(null);
        assertDoesNotThrow(()->roleService.deleteRole(role.getName()));
        Mockito.verify(repository).findByName(role.getName());
    }
    @Test void deleteRoleWithNotValidRequest(){
        Role role= new Role("ADMIN");
        when(repository.findByName(role.getName())).thenReturn(new Role("ADMIN",new Date(),new Date(),new Date()));
        when(repository.save(role)).thenReturn(null);
        assertThrowsExactly(RuntimeException.class,()->roleService.deleteRole(role.getName()));
        Mockito.verify(repository).findByName(role.getName());
    }

}