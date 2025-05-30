package com.igorjava.shawarmadelivery.domain.interactor;

import com.igorjava.shawarmadelivery.domain.model.*;
import com.igorjava.shawarmadelivery.domain.repo.OrderRepo;
import java.util.List;

public class OrderInteractor {

    private final OrderRepo repo;

    public OrderInteractor(OrderRepo repo) {
        this.repo = repo;
    }

    public IOrder createOrder(IOrder order){
        return repo.saveOrder(order);
    }

    public IOrder changeOrder(IOrder order){
        return repo.updateOrder(order);
    }

    public IOrder updateOrderStatus(Long orderId, OrderStatus status){ return repo.updateOrderStatus(orderId, status); }

    public List<IOrder> getOrdersByUser(IUser user){
        return repo.getOrdersByUser(user);
    }

    public List<IOrder> getOrdersByStatus(OrderStatus status){
        return repo.getOrdersByStatus(status);
    }

}
