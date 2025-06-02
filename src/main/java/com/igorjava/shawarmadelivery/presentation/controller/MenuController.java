package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.domain.model.IMenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import com.igorjava.shawarmadelivery.presentation.service.MenuItemService;
import com.igorjava.shawarmadelivery.presentation.service.SessionInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuItemService menuService;
    private final SessionInfoService sessionInfoService;

    public MenuController(MenuItemService menuService, SessionInfoService sessionInfoService) {
        this.menuService = menuService;
        this.sessionInfoService = sessionInfoService;
    }

    @GetMapping
    public String showMenu(Model model){
        Map<String, List<IMenuItem>> menuItemsBySection = Map.of(
                "menu.main_menu", menuService.getMenuItemsBySection(MenuSection.MAIN_MENU),
                "menu.snacks", menuService.getMenuItemsBySection(MenuSection.SNACKS),
                "menu.supplements", menuService.getMenuItemsBySection(MenuSection.SUPPLEMENTS),
                "menu.sauces", menuService.getMenuItemsBySection(MenuSection.SAUCES));
        model.addAttribute("menuItemsBySection", menuItemsBySection);
        return "menu";
    }

    @PostMapping("/order")
    public String processOrderForm(
            @RequestParam(required = false) List<Long> selectedId,
            @RequestParam(required = false) List<Integer> quantities,
            Model model
    ){
        if (selectedId == null || selectedId.isEmpty()) {
            model.addAttribute("error", "Please, select at least 1 item to place an order.");
            return showMenu(model);
        }

        List<IMenuItem> selectedMenuItems = new ArrayList<>();
        for (int i = 0; i < selectedId.size(); i++) {
            for (int j = 0; j < quantities.get(i); j++) {
                selectedMenuItems.add(menuService.getMenuItemById(selectedId.get(i)));
            }
        }
        sessionInfoService.setCart(selectedMenuItems);
        model.addAttribute("sessionInfoService", sessionInfoService);
        return "order";
    }
}
