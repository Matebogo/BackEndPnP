/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Role;
import com.web.pnp.model.User;
import com.web.pnp.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.pnp.repository.UserRepository;

/**
 *
 * @author Reverside
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
        User user = null;
        for (int i = 0; i < this.getAllUser().size(); i++) {

            user = this.getAllUser().get(i);

    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();

    }

    public void addUser(User user) {

        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);

    }

    public User find(int id) {
        return userRepository.getOne(id);
    }

    public User getByUserName(String username) {


            if (this.getAllUser().get(i).getUsername().equals(username)) {

                user = this.getAllUser().get(i);
                break;
            }
        }

        return user;
    }

    public User loginUser(String username, String password) {

        User user = new User();

        if (!this.getAllUser().isEmpty()) {

            for (int i = 0; i < this.getAllUser().size(); i++) {

                if (this.getAllUser().get(i).getUsername().equals(username)
                        && this.getAllUser().get(i).getPassword().equals(password)) {

                    user = this.getAllUser().get(i);
                    break;

                }
                else{
                    user = null;
                }

            }

        }
        
        return user;

    }
}
