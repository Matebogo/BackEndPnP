package com.web.pnp.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.web.pnp.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
    
}
