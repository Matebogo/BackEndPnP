/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.User;
import com.web.pnp.repository.UserRepository;
import com.web.pnp.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {
        for (User users : getAllUser()) {
            if (users.getEmail().equals(user.getEmail())) {
                return "User already exists";
            }
        }

        userService.addUser(user);
        return "saved succesfully";
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return true;
    }

    @CrossOrigin
    @PutMapping(value = "/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);

    }

    @RequestMapping(value = "/user-by-username/{username}", method = RequestMethod.GET)
    public User getByUserName(@PathVariable String username) {
        return userService.getByUserName(username);
    }

    @RequestMapping(value = "/login-user/{username}/{password}", method = RequestMethod.GET)
    public User login(@PathVariable String username, @PathVariable String password) {
        return this.userService.loginUser(username, password);
    }
    
    //Let me create a method that will retrieve one user from the DB
    
   @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public User find(@PathVariable int id){
    
        return userService.find(id);
    }

}
