package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.presentation.service.DeliveryService;
import com.igorjava.shawarmadelivery.presentation.service.OrderService;
import org.springframework.stereotype.Controller;

@Controller
public class OrderAndDeliveryController {

    private final OrderService orderService;
    private final DeliveryService deliveryService;

    public OrderAndDeliveryController(OrderService orderService, DeliveryService deliveryService) {
        this.orderService = orderService;
        this.deliveryService = deliveryService;
    }
}
