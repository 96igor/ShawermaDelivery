package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.domain.model.OrderStatus;
import com.igorjava.shawarmadelivery.presentation.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private final OrderService orderService;

    public AdminController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showAdminPanel(Model model){
        model.addAttribute("newOrders", orderService.getOrdersByStatus(OrderStatus.NEW));
        return "admin";
    }

    @PostMapping("orders/update/{id}")
    public String updateOrderStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status
    ){
        orderService.updateOrderStatus(id, status);
        log.info(String.valueOf(orderService.getOrdersByStatus(OrderStatus.CONFIRMED)));
        return "redirect:/admin";
    }
}
