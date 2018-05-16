/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Reverside
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Driver extends User implements Serializable{
    
      public Driver() {
    }

    public Driver(User user) {
        super();
    }
}
