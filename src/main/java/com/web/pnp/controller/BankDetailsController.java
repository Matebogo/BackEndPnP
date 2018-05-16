/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.BankDetails;
import com.web.pnp.service.BankDetailsService;
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
@RequestMapping(value = "/bank-details")
public class BankDetailsController {
    
    @Autowired
    private BankDetailsService bankDetailService;
    
     
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<BankDetails> accounts(){
    
        return bankDetailService.accounts();
    }
    
    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public void createAccount(@RequestBody BankDetails bankDetail){
    
        bankDetailService.createBankAccount(bankDetail);
    }
    
    @RequestMapping(value = "/delete-account/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable int id){
    
        bankDetailService.deleteAccount(id);
    }
    
    @RequestMapping(value = "/find-account/{id}", method = RequestMethod.GET)
    public BankDetails getAccount(@PathVariable int id){
    
        return bankDetailService.getAccount(id);
    }
    
    @RequestMapping(value = "/update-account", method = RequestMethod.PUT)
    public BankDetails updateAccount(@RequestBody BankDetails bankDetail){
    
        return bankDetailService.updateAccount(bankDetail);
    }
}