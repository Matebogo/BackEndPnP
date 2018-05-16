/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.Customer;
import com.web.pnp.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @CrossOrigin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customer> getAllUser() {
        return customerService.getAllCustomer();
    }

    @CrossOrigin
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@RequestBody Customer customer) {
        for (Customer users : getAllUser()) {
            if (users.getEmail().equals(customer.getEmail())) {
                return "User already exists";
            }
        }

        customerService.addCustomer(customer);
        return "saved succesfully";
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return true;
    }

    @CrossOrigin
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);

    }
    @RequestMapping(value = "/findusername/{id}", method = RequestMethod.GET)
    public Customer find(@PathVariable int id){
    
        return customerService.find(id);
    }

    @RequestMapping(value = "/login-customer", method = RequestMethod.GET)
    public Customer login(@RequestParam String username,@RequestParam String password) {

        return this.customerService.loginCustomer(username, password);
    }
}
