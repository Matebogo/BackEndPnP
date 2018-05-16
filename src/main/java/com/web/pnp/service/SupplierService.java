/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Role;
import com.web.pnp.model.Supplier;
import com.web.pnp.repository.RoleRepository;
import com.web.pnp.repository.SupplierRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    public void addSupplier(Supplier supplier) {

         Role role = roleRepository.getOne(3);
        
        String roleName = role.getName();
        role.setName(roleName);
        
         Set<Role> roles = new HashSet<Role>(){{
        
            add(role);
        }};
         
         supplier.setRoles(roles);
        
       
        this.supplierRepository.save(supplier);

    }

    public void deleteSupplier(int supplierID) {

        supplierRepository.deleteById(supplierID);
    }

    public List<Supplier> allSuppliers() {

        return this.supplierRepository.findAll();
    }
}
