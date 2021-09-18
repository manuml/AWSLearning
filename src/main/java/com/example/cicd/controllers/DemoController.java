package com.example.cicd.controllers;

import com.example.cicd.exceptions.OrderNotFoundException;
import com.example.cicd.models.Order;
import com.example.cicd.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private OrderService orderService;

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        logger.info("Getting all orders...");
        return  orderService.getOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable("id") Integer id){
        Order order = new Order();
        try {
            logger.info("Getting order by id ");
            order = orderService.getOrderById(id);
        } catch (OrderNotFoundException e) {
            logger.error(String.valueOf(e));
        }
        return order;
    }


}
