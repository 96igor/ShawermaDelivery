package com.igorjava.shawarmadelivery.domain.repo;

import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import java.util.List;

public interface MenuItemRepo {
    MenuItem saveMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(MenuItem menuItem);
    MenuItem getMenuItemById(Long id);
    List<MenuItem> getMenuItemBySection(MenuSection section);
    void deleteMenuItem(MenuItem menuItem);
}
