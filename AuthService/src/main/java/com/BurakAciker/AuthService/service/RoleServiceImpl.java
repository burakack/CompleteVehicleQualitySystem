package com.BurakAciker.AuthService.service;

import com.BurakAciker.AuthService.dao.RoleRepository;
import com.BurakAciker.AuthService.domain.Role;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service @RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final Logger logger = LogManager.getLogger(RoleServiceImpl.class);
    private final RoleRepository roleRepository;


    @Override
    public void createRole(@NotNull Role role) {
        logger.info("Create role service method:" + role.toString());
        Role role1=roleRepository.findByName(role.getName());
        if(role1.getDeletedAt()==null){
            logger.warn("Role already exists");
            throw new RuntimeException("Role already exists");
        }
        else if(role1.getDeletedAt()!=null){
            role1.setDeletedAt(new Date());
            logger.warn("Role already exists");
            throw new RuntimeException("Role already exists");
        }
        else {
            logger.info("Role created"+role.toString());
            roleRepository.save(role);
        }
    }

    @Override
    public Role getRoleByName(@NotNull String name) {
        logger.info("Get role by name role name:" + name);
        Role role=roleRepository.findByName(name);
        if(role.getDeletedAt()!=null) {
            logger.warn("Role found: "+role.toString());
            return role;
        }
        else{
            logger.warn("Role not found");
            return null;
        }
    }

    @Override
    public void deleteRole(@NotNull String rolename) {
        logger.info("Delete role service method rolename:" + rolename);
        Role deletedrole=roleRepository.findByName(rolename);
        if(deletedrole == null) {
            logger.warn("Role not found");
            throw new RuntimeException("Role not found");
        }
        if(deletedrole.getDeletedAt()!=null){
            logger.warn("Role already deleted");
            throw new RuntimeException("Role already deleted");
        }else if(deletedrole.getDeletedAt()==null)
        {
            logger.info("Role deleted"+deletedrole.toString());
            deletedrole.setDeletedAt(new Date());
        }
    }
}
