/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.Admin;
import com.web.pnp.model.Driver;
import com.web.pnp.service.AdminService;
import com.web.pnp.service.DriverService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createAdmin(@RequestBody Admin admin){
    
        if( admin != null){
        
            this.adminService.registerAdmin(admin);
        }
       
        return "Driver successfully saved!!";
    }
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Admin> admins(){
    
        return adminService.admins();
    }
    
    @RequestMapping(value = "/getAdmin/{adminID}", method = RequestMethod.GET)
    public Admin Admins(@PathVariable int adminID){
    
        return this.adminService.getAdmin(adminID);
    }
    
    @RequestMapping(value = "/delete/{adminID}", method = RequestMethod.DELETE)
    public void deleteAdmin(@PathVariable int adminID){
    
        this.adminService.deleteAdmin(adminID);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Admin updateAdmin(@RequestBody Admin admin){
    
       return this.adminService.updateAdmin(admin);
    }
}

