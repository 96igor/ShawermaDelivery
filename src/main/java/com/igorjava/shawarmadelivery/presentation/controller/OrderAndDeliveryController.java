package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.presentation.service.DeliveryService;
import com.igorjava.shawarmadelivery.presentation.service.MenuItemService;
import com.igorjava.shawarmadelivery.presentation.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderAndDeliveryController {

    private static final Logger log = LoggerFactory.getLogger(OrderAndDeliveryController.class);

    private final MenuItemService menuItemService;
    private final OrderService orderService;
    private final DeliveryService deliveryService;

    public OrderAndDeliveryController(MenuItemService menuItemService, OrderService orderService, DeliveryService deliveryService) {
        this.menuItemService = menuItemService;
        this.orderService = orderService;
        this.deliveryService = deliveryService;
    }

    @PostMapping("/order")
    public String showOrderForm(
            @RequestParam List<Long> selectedId,
            @RequestParam List<Integer> quentites,
            Model model
    ){
        List<MenuItem> selectedMenuItems = new ArrayList<>();
        for (int i = 0; i < selectedId.size(); i++) {
            for (int j = 0; j < quentites.get(i); j++) {
                selectedMenuItems.add(menuItemService.getMunuItemById(selectedId.get(i)));
            }
        }

        log.info("selectedItems: {}", selectedId);
        log.info("quentites: {}", quentites);

        BigDecimal totalPrice = selectedMenuItems.stream()
                .map(MenuItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("selectedMenuItems", selectedMenuItems);
        model.addAttribute("totalPrice", totalPrice);
        return "order";
    }
}
