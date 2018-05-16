/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.controller;

import com.web.pnp.model.Product;
import com.web.pnp.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Product> getAll() {

        return productService.getAllProducts();
    }

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProduct(@RequestBody Product product) {

        productService.saveProduct(product);

        return "Product saved successfully";
    }

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {

        return productService.updateProduct(product);

    }

    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }

    @CrossOrigin
    @RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {

        return productService.getProduct(id);
    }
    @RequestMapping(value = "/productSupplier/{supplierID}", method = RequestMethod.GET)
    public List<Product> getAllBySupplierID(@PathVariable int supplierID) {

        return productService.getBySupplierID(supplierID);
    }
}
