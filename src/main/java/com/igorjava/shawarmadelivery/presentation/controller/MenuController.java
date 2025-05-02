package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.presentation.service.MenuItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuItemService service;

    public MenuController(MenuItemService service) {
        this.service = service;
    }

    @GetMapping
    public String showMenu(){

        return "menu";
    }

}
