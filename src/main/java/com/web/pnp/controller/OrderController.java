package com.web.pnp.controller;

/**
 *
 * @author Reverside
 */
import com.web.pnp.model.Orders;
import com.web.pnp.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void createOrder(@RequestBody Orders order) {

        orderService.createOrder(order);
    }

    @CrossOrigin
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Orders> getOrders() {

        return orderService.getOrders();
    }

    @CrossOrigin
    @RequestMapping(value = "/single-order/{id}", method = RequestMethod.GET)
    public Orders getOrder(@PathVariable int id) {

        return orderService.getOrder(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/delete-order/{id}", method = RequestMethod.DELETE)
    public void removeOrder(@PathVariable int id) {

        orderService.deleteOrder(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/update-order", method = RequestMethod.PUT)
    public Orders updateOrder(@RequestBody Orders order) {

        return orderService.updateOrder(order);
    }

    @CrossOrigin
    @RequestMapping(value = "/customer-orders/{customerID}", method = RequestMethod.GET)
    public List<Orders> customerOrders(@PathVariable int customerID) {

        return this.orderService.getCustomerOrders(customerID);

    }
}
