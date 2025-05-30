package com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw;

import com.igorjava.shawarmadelivery.domain.model.IMenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import com.igorjava.shawarmadelivery.domain.repo.MenuItemRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuItemRepoImpl implements MenuItemRepo {

    private final List<IMenuItem> items=new ArrayList<>();

    @Override
    public IMenuItem saveMenuItem(IMenuItem menuItem) {
        items.add(menuItem);
        return menuItem;
    }

    @Override
    public IMenuItem updateMenuItem(IMenuItem menuItem) {
        int index=items.indexOf(menuItem);
        if (index != -1) items.set(index,menuItem);
        return menuItem;
    }

    @Override
    public IMenuItem getMenuItemById(Long id) {
        return items.stream()
                .filter(menuItem -> menuItem.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<IMenuItem> getMenuItemBySection(MenuSection section) {
        return items.stream()
                .filter(item-> item.getMenuSection().name().equals(section.name()))
                .toList();
    }

    @Override
    public void deleteMenuItem(IMenuItem menuItem) {
        items.remove(menuItem);
    }
}
