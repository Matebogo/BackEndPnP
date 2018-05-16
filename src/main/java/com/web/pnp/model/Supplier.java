package com.web.pnp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplier extends User implements Serializable {

    public Supplier() {
    }

    public Supplier(User user) {
       super();
    }
     
}
