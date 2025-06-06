package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.domain.model.*;
import com.igorjava.shawarmadelivery.presentation.service.*;
import com.igorjava.shawarmadelivery.presentation.service.dto.OrderDto;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderAndDeliveryController {

    private static final Logger log = LoggerFactory.getLogger(OrderAndDeliveryController.class);

    private final OrderService orderService;
    private final DeliveryService deliveryService;
    private final UserService userService;
    private final SessionInfoService sessionInfoService;

    public OrderAndDeliveryController(OrderService orderService, DeliveryService deliveryService, UserService userService, SessionInfoService sessionInfoService) {
        this.orderService = orderService;
        this.deliveryService = deliveryService;
        this.userService = userService;
        this.sessionInfoService = sessionInfoService;
    }

    @GetMapping("/order")
    public String showOrderForm(Model model) {
        model.addAttribute("orderDto", new OrderDto());
        return "order";
    }

    @PostMapping("/order/submit")
    public String orderSubmit(
            @Valid @ModelAttribute SessionInfoService sessionInfoService,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            model.addAttribute("sessionInfoService", sessionInfoService);
            showOrderForm(model);
        }
        log.info("sessionInfoService: {}", sessionInfoService);
        log.info("userService.getUserByEmail: {}", userService.getUserByEmail(sessionInfoService.getEmail()));
        log.info("sessionInfoService.getEmail(): {}", sessionInfoService.getEmail());
        IUser user = userService.getUserByEmail(sessionInfoService.getEmail());
        user.setAddress(sessionInfoService.getAddress());
        user.setName(sessionInfoService.getUsername());
        user.setPhone(sessionInfoService.getPhone());

        List<IMenuItem> selectedMenuItems = sessionInfoService.getCart();
        BigDecimal totalPrice = sessionInfoService.getTotalPrice();


        Order order = new Order(
                null,
                LocalDateTime.now(),
                OrderStatus.NEW,
                null,
                selectedMenuItems,
                totalPrice
        );

        order.setStatus(OrderStatus.NEW);
        order.setItemList(sessionInfoService.getCart());
        order.setTotalPrice(sessionInfoService.getTotalPrice());
        order.setDateTime(LocalDateTime.now());
        order.setUser(user);

        Delivery delivery = new Delivery();
        delivery.setDateTime(LocalDateTime.now());
        delivery.setPhone(sessionInfoService.getPhone());
        delivery.setAddress(sessionInfoService.getAddress());
        delivery.setOrder(order);

        orderService.createOrder(delivery.getOrder());
        deliveryService.createDelivery(delivery);
        userService.createUser(user);
        return "redirect:/menu";
    }
}
