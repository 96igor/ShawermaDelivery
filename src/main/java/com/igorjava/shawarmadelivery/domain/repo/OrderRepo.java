package com.igorjava.shawarmadelivery.domain.repo;

import com.igorjava.shawarmadelivery.domain.model.Order;
import com.igorjava.shawarmadelivery.domain.model.OrderStatus;
import com.igorjava.shawarmadelivery.domain.model.User;
import java.util.List;

public interface OrderRepo {
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    Order updateOrderStatus(Long orderId, OrderStatus status);
    List<Order> getOrdersByUser(User user);
    List<Order> getOrdersByStatus(OrderStatus orderStatus);
}
