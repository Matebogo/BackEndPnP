/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.repository;

import com.web.pnp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Reverside
 */
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
}
