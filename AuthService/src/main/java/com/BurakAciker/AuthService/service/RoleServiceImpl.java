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
        Role role1=roleRepository.findByName(role.getName());
        if(role1.getDeletedAt()==null){
            throw new RuntimeException("Role already exists");
        }
        else if(role1.getDeletedAt()!=null){
            role1.setDeletedAt(new Date());
            throw new RuntimeException("Role already exists");
        }
        else {
            roleRepository.save(role);
        }
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
        if(deletedrole == null) {
            throw new RuntimeException("Role not found");
        }
        if(deletedrole.getDeletedAt()!=null){
            throw new RuntimeException("Role already deleted");
        }else if(deletedrole.getDeletedAt()==null)
        {
            deletedrole.setDeletedAt(new Date());
        }
    }
}
