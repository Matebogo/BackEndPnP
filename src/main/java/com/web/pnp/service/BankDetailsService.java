/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.BankDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.web.pnp.repository.BankDetailsRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class BankDetailsService {
    
    @Autowired
    private BankDetailsRepository bankDetailRepository;
    
    public void createBankAccount(BankDetails bankDetail){
        
        bankDetailRepository.save(bankDetail);
        
    }
    
    public List<BankDetails> accounts(){
    
        return bankDetailRepository.findAll();
    }
    
    public BankDetails getAccount(int  id){
        
        
        return bankDetailRepository.getOne(id);
    
    }
    
    public void deleteAccount(int id){
    
        bankDetailRepository.deleteById(id);
    }
    
    public BankDetails updateAccount(BankDetails bankDetail){
        
        
        BankDetails bd = this.getAccount(bankDetail.getId());
        
        if( bd == null){
            
            return null;
        }
    
        return bankDetailRepository.save(bankDetail);
    }
}