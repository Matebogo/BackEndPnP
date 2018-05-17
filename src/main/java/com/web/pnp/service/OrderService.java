package com.web.pnp.service;

import com.web.pnp.model.Orders;
import com.web.pnp.repository.OrdersRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reverside
 */
@Service
public class OrderService {

    @Autowired
    private OrdersRepository orderRepository;

    public void createOrder(Orders order) {

        orderRepository.save(order);
    }

    public Orders getOrder(int id) {

        return orderRepository.getOne(id);
    }

    public void deleteOrder(int id) {

        orderRepository.deleteById(id);
    }

    public List<Orders> getOrders() {

        return this.orderRepository.findAll();
    }
    
    public Orders updateOrder(Orders order){
    
        Orders ordered = orderRepository.getOne(order.getOrderID());
        
        if(ordered == null){
        
            return null;
        }
        
        return orderRepository.save(order);
    }
      public List<Orders> getCustomerOrders(String username){
    
        List<Orders> orders = this.getOrders();
        List<Orders> customerOrders = new ArrayList<>();
        
        if(!orders.isEmpty()){
        
            for (int i = 0; i < orders.size(); i++) {
                
                if(orders.get(i).getUsername()== username){
                
                    customerOrders.add(orders.get(i));
                }
            }
            
        }
        
        return customerOrders;
        
    }

    
}