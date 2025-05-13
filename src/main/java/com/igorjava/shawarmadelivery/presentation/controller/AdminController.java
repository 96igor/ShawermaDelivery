package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.domain.model.OrderStatus;
import com.igorjava.shawarmadelivery.presentation.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final OrderService orderService;

    public AdminController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showAdminPanel(Model model){
        model.addAttribute("newOrders", orderService.getOrdersByStatus(OrderStatus.NEW));
        return "admin";
    }
}
