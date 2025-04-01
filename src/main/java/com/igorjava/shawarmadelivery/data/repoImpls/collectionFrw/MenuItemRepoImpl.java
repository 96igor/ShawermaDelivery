package com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw;

import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import com.igorjava.shawarmadelivery.domain.repo.MenuItemRepo;

import java.util.ArrayList;
import java.util.List;

public class MenuItemRepoImpl implements MenuItemRepo {

    private final List<MenuItem> items=new ArrayList<>();

    @Override
    public MenuItem saveMenuItem(MenuItem menuItem) {
        items.add(menuItem);
        return menuItem;
    }

    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
        int index=items.indexOf(menuItem);
        if (index != -1) items.set(index,menuItem);
        return menuItem;
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return items.stream()
                .filter(menuItem -> menuItem.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<MenuItem> getMenuItemBySection(MenuSection section) {
        return items.stream()
                .filter(item-> item.getMenuSection().name().equals(section.name()))
                .toList();
    }

    @Override
    public void deleteMenuItem(MenuItem menuItem) {
        items.remove(menuItem);
    }
}
