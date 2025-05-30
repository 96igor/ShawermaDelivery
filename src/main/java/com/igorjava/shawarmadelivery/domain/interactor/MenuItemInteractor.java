package com.igorjava.shawarmadelivery.domain.interactor;

import com.igorjava.shawarmadelivery.domain.model.IMenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import com.igorjava.shawarmadelivery.domain.repo.MenuItemRepo;

import java.util.List;

public class MenuItemInteractor {

    private final MenuItemRepo repo;

    public MenuItemInteractor(MenuItemRepo repo) {
        this.repo = repo;
    }

    public IMenuItem saveMenuItem(IMenuItem menuItem){
         return repo.saveMenuItem(menuItem);
    }

    public IMenuItem updateMenuItem(IMenuItem menuItem){
        return repo.updateMenuItem(menuItem);
    }

    public List<IMenuItem> getMenuItemsBySection(MenuSection section){
        return repo.getMenuItemBySection(section);
    }

    public IMenuItem getMenuItemById(Long id){
        return repo.getMenuItemById(id);
    }

}
