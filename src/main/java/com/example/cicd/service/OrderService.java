package com.example.cicd.service;

import com.example.cicd.exceptions.OrderNotFoundException;
import com.example.cicd.models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    List<Order> orders = new ArrayList<Order>(Arrays.asList(
            new Order(12, "PMG097733", new String[]{
                    "Tooth brush", "Tooth paste"
            }, 43.90, "20200907"),
            new Order(13, "PMG096445", new String[]{
                    "Turmeric powder", "Gillette blade set"
            }, 12.50, "20200908"),
            new Order(14, "PMG091253", new String[]{
                    "vegetables", "milk"
            }, 33.12, "20200908"),
            new Order(15, "PMG090988", new String[]{
                    "bicycle", "laptop"
            }, 14344.89, "20200909"),
            new Order(16, "PMG091515", new String[]{
                    "pendrive", "bluetooth headset"
            }, 3390.50, "20200910")
    ));

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Order> order = orders.stream().filter(n -> n.getOrderId().equals(id)).findFirst();
        if (order.isPresent())
            return order.get();
        throw new OrderNotFoundException("Order Id not found");

    }
}
