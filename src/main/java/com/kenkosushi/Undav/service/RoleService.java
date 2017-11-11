package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Role;
import com.kenkosushi.Undav.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    public Role findById(Long id){
        return roleRepository.findOne(id);
    }

    public Collection<Role> findAll(){
        return roleRepository.findAll();
    }

    public void save(Role role){
        roleRepository.save(role);
    }

    public void update(Role role){
        roleRepository.save(role);
    }

    public void delete(Long id){
        roleRepository.delete(id);
    }
}
