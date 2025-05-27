package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import com.igorjava.shawarmadelivery.presentation.service.MenuItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuItemService service;

    public MenuController(MenuItemService service) {
        this.service = service;
    }

    @GetMapping
    public String showMenu(Model model){
        Map<String, List<MenuItem>> menuItemsBySection = Map.of(
                "menu.main_menu", service.getMenuItemsBySection(MenuSection.MAIN_MENU),
                "menu.snacks", service.getMenuItemsBySection(MenuSection.SNACKS),
                "menu.supplements", service.getMenuItemsBySection(MenuSection.SUPPLEMENTS),
                "menu.sauces", service.getMenuItemsBySection(MenuSection.SAUCES));
        model.addAttribute("menuItemsBySection", menuItemsBySection);
        return "menu";
    }

}
