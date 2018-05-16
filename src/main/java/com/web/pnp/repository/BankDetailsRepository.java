/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.repository;

import com.web.pnp.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface BankDetailsRepository extends JpaRepository<BankDetails, Integer>{
    
}
