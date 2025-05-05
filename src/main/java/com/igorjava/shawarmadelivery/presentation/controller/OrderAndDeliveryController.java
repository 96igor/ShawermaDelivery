package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.presentation.service.DeliveryService;
import com.igorjava.shawarmadelivery.presentation.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class OrderAndDeliveryController {

    private static final Logger log = LoggerFactory.getLogger(OrderAndDeliveryController.class);

    private final OrderService orderService;
    private final DeliveryService deliveryService;

    public OrderAndDeliveryController(OrderService orderService, DeliveryService deliveryService) {
        this.orderService = orderService;
        this.deliveryService = deliveryService;
    }

    @PostMapping("/order")
    public String showOrderForm(
            @RequestParam List<Long> selectedItems,
            @RequestParam List<Integer> quentites,
            Model model
    ){
        log.info("selectedItems: {}", selectedItems);
        log.info("quentites: {}", quentites);
        return "order";
    }
}
