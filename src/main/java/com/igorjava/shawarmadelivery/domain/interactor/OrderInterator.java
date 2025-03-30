package com.igorjava.shawarmadelivery.domain.interactor;

import com.igorjava.shawarmadelivery.domain.model.Order;
import com.igorjava.shawarmadelivery.domain.model.OrderStatus;
import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.domain.repo.OrderRepo;

import java.util.List;

public class OrderInterator {

    private final OrderRepo repo;

    public OrderInterator(OrderRepo repo) {
        this.repo = repo;
    }

    public Order createOrder(Order order){
        return repo.saveOrder(order);
    }

    public Order changeOrder(Order order){
        return repo.updateOrder(order);
    }

    public List<Order> getOrdersByUser(User user){
        return repo.getOrdersByUser(user);
    }

    public List<Order> getOrdersByStatus(OrderStatus status){
        return repo.getOrdersByStatus(status);
    }

}
