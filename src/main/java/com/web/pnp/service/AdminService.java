/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Admin;
import com.web.pnp.model.Role;
import com.web.pnp.repository.AdminRepository;
import com.web.pnp.repository.RoleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void registerAdmin(Admin admin) {

        Role role = roleRepository.getOne(1);

        String roleName = role.getName();
        role.setName(roleName);

        Set<Role> roles = new HashSet<Role>() {
            {

                add(role);
            }
        };

        admin.setRoles(roles);

        adminRepository.save(admin);

    }

    public void deleteAdmin(int adminId) {

        adminRepository.deleteById(adminId);

    }

    public Admin getAdmin(int adminId) {

        return adminRepository.getOne(adminId);

    }

    public Admin updateAdmin(Admin admin) {

        Admin a = this.getAdmin(admin.getId());

        if (a == null) {

            return null;
        }

        return adminRepository.save(admin);
    }

    public List<Admin> admins() {

        return this.adminRepository.findAll();
    }
}

