/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.pnp.service;

import com.web.pnp.model.Product;
import com.web.pnp.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(int id) {

        return productRepository.getOne(id);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {

        Product products = productRepository.getOne(product.getProductId());

        if (products == null) {

            return null;
        }

        return productRepository.save(product);
    }

    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }
     public ArrayList<Product> getBySupplierID(int supplierID){
    
        List<Product> products = getAllProducts();
        
        ArrayList<Product> pts = new ArrayList<>();
        
        if(!products.isEmpty()){
            for (int i = 0; i < products.size(); i++) {
                
                if( products.get(i).getSupplier().getId()== supplierID){
                
                    pts.add(products.get(i));
                }
            }
        } else {
        }
        
       return pts;
    }
}
