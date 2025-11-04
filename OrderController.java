package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")

public class OrderController {
    @Autowired
    private OrderRepository OrderRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/{userId}")
    public Order createOrder(@PathVariable int userId, @RequestBody Order order) {
        User user = userRepository.findById(userId).orElseThrow(()-> new  RuntimeException("User not found"));
        order.setUser(user);
        return OrderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return OrderRepository.findAll();
    }  
    
     @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getOrders();
    }
    @PutMapping("/{id}")
public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
    Order existingOrder = OrderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    
    existingOrder.setProductName(updatedOrder.getProductName());
    existingOrder.setAmount(updatedOrder.getAmount());
    
    return OrderRepository.save(existingOrder);
}


    }
    

