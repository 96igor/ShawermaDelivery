package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.domain.model.*;
import com.igorjava.shawarmadelivery.presentation.service.DeliveryService;
import com.igorjava.shawarmadelivery.presentation.service.MenuItemService;
import com.igorjava.shawarmadelivery.presentation.service.OrderService;
import com.igorjava.shawarmadelivery.presentation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderAndDeliveryController {

    private static final Logger log = LoggerFactory.getLogger(OrderAndDeliveryController.class);

    private final MenuItemService menuItemService;
    private final OrderService orderService;
    private final DeliveryService deliveryService;
    private final UserService userService;

    public OrderAndDeliveryController(MenuItemService menuItemService, OrderService orderService, DeliveryService deliveryService, UserService userService) {
        this.menuItemService = menuItemService;
        this.orderService = orderService;
        this.deliveryService = deliveryService;
        this.userService = userService;
    }

    @PostMapping("/order")
    public String showOrderForm(
            @RequestParam List<Long> selectedId,
            @RequestParam List<Integer> quantities,
            Model model
    ){
        List<MenuItem> selectedMenuItems = new ArrayList<>();
        for (int i = 0; i < selectedId.size(); i++) {
            for (int j = 0; j < quantities.get(i); j++) {
                selectedMenuItems.add(menuItemService.getMenuItemById(selectedId.get(i)));
            }
        }

        log.info("selectedItems: {}", selectedId);
        log.info("quantities: {}", quantities);

        BigDecimal totalPrice = selectedMenuItems.stream()
                .map(MenuItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order = new Order(
                null,
                LocalDateTime.now(),
                OrderStatus.NEW,
                null,
                selectedMenuItems,
                totalPrice
        );
        order.setStatus(OrderStatus.NEW);
        order.setItemList(selectedMenuItems);
        order.setTotalPrice(totalPrice);
        order.setDateTime(LocalDateTime.now());

        Delivery delivery = new Delivery();

        User user = new User();

        delivery.setOrder(order);
        model.addAttribute("delivery", delivery);
        model.addAttribute("order", order);
        model.addAttribute("user", user);
        return "order";
    }
    @PostMapping("/order/submit")
    public String orderSubmit(
            @ModelAttribute Delivery delivery,
            @ModelAttribute Order order,
            @ModelAttribute User user
    ){
        log.info("delivery: {}", delivery);
        log.info("order: {}", order);
        log.info("user: {}", user);
        order.setUser(user);
        delivery.setOrder(order);

        orderService.changeOrder(delivery.getOrder());
        deliveryService.createDelivery(delivery);
        userService.createUser(user);
        return "redirect:/menu";
    }
}
