/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Role;
import com.web.pnp.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reverside
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    

    public List<Role> getRoles() {
        return roleRepository.findAll();

    }

    public void addRole(int id) {
        roleRepository.getOne(id);
    }
}