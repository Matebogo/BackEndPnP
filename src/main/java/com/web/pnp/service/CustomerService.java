/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Customer;
import com.web.pnp.model.Role;
import com.web.pnp.repository.CustomerReposity;
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
public class CustomerService {

    @Autowired
    private CustomerReposity customerRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();

    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();

    }

    public void addCustomer(Customer customer) {
        Role role = roleRepository.getOne(2);
        String roleName = role.getName();
        role.setName(roleName);

        Set<Role> roles = new HashSet<Role>() {
            {
                add(role);
            }
        };
        customer.setRoles(roles);
        customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);

    }

    public Customer find(int id) {
        return customerRepository.getOne(id);
    }

    public Customer loginCustomer(String username, String password) {

        Customer c = new Customer();
        if (!this.getAllCustomer().isEmpty()) {

            for (int i = 0; i < this.getAllCustomer().size(); i++) {

                if (this.getAllCustomer().get(i).getUsername().equals(username)
                        && this.getAllCustomer().get(i).getPassword().equals(password)) {

                    c = this.getAllCustomer().get(i);

                }
            }
        }

        return c;
    }
}
