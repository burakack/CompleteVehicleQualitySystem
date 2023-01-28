package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.dao.RoleRepository;
import com.BurakAciker.AuthService.domain.Role;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service @RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public void createRole(@NotNull Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(@NotNull String name) {
        Role role=roleRepository.findByName(name);
        if(role.getDeletedAt()!=null)
            return role;
        else{
            return null;
        }
    }

    @Override
    public void deleteRole(@NotNull Role role) {
        Role deletedrole=roleRepository.findByName(role.getName());
        deletedrole.setDeletedAt(new Date());
    }
}
