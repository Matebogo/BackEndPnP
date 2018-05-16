/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.Supplier;
import com.web.pnp.service.SupplierService;
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
@RequestMapping("/supplier")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void addSupplier(@RequestBody Supplier supplier){
    
        this.supplierService.addSupplier(supplier);
        
    }
    
    @RequestMapping(value = "/delete/{supplierID}", method = RequestMethod.DELETE)
    public void deleteSupplier(@PathVariable int supplierID){
    
        this.supplierService.deleteSupplier(supplierID);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Supplier> allSuppliers(){
    
        return this.supplierService.allSuppliers();
    }
    
}
