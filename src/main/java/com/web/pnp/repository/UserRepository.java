/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.repository;

import com.web.pnp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reverside
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
    public User findOneByUsername(String username);
    public User findByEmail(String email);
}
