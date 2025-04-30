package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.presentation.service.MenuItemService;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {

    private final MenuItemService service;

    public MenuController(MenuItemService service) {
        this.service = service;
    }
}
