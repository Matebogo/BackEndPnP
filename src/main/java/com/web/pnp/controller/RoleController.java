/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.Role;
import com.web.pnp.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleRepository roleRepository;
    
   
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Role> getAllRole(){
        
        return roleRepository.findAll();
    }
    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRole(@RequestBody Role role){
    
        roleRepository.save(role);
        
        return "Role successfully added!!";
    }
}
