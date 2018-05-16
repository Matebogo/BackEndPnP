/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Driver;
import com.web.pnp.model.Role;
import com.web.pnp.repository.DriverRepository;
import com.web.pnp.repository.RoleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reverside
 */
@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void registerDriver(Driver driver) {

        Role role = roleRepository.getOne(4);

        String roleName = role.getName();
        role.setName(roleName);

        Set<Role> roles = new HashSet<Role>() {
            {

                add(role);
            }
        };

        driver.setRoles(roles);

        driverRepository.save(driver);

    }

    public void deleteDriver(int driverID) {

        driverRepository.deleteById(driverID);

    }

    public Driver getDriver(int driverID) {

        return driverRepository.getOne(driverID);

    }

    public Driver updateDriver(Driver driver) {

        Driver d = this.getDriver(driver.getId());

        if (d == null) {

            return null;
        }

        return driverRepository.save(driver);
    }

    public List<Driver> drivers() {

        return this.driverRepository.findAll();
    }
}
