package com.igorjava.shawarmadelivery.domain.interactor;

import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import com.igorjava.shawarmadelivery.domain.repo.MenuItemRepo;

import java.util.List;

public class MenuItemInteractor {

    private final MenuItemRepo repo;

    public MenuItemInteractor(MenuItemRepo repo) {
        this.repo = repo;
    }

    public MenuItem saveMenuItem(MenuItem menuItem){
         return repo.saveMenuItem(menuItem);
    }

    public MenuItem updateMenuItem(MenuItem menuItem){
        return repo.updateMenuItem(menuItem);
    }

    public List<MenuItem> getMenuItemsBySection(MenuSection section){
        return repo.getMenuItemBySection(section);
    }

    public MenuItem getMunuItemById(Long id){
        return repo.getMenuItemById(id);
    }

}
