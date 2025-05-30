package com.igorjava.shawarmadelivery.domain.repo;

import com.igorjava.shawarmadelivery.domain.model.IMenuItem;
import com.igorjava.shawarmadelivery.domain.model.MenuSection;
import java.util.List;

public interface MenuItemRepo {
    IMenuItem saveMenuItem(IMenuItem menuItem);
    IMenuItem updateMenuItem(IMenuItem menuItem);
    IMenuItem getMenuItemById(Long id);
    List<IMenuItem> getMenuItemBySection(MenuSection section);
    void deleteMenuItem(IMenuItem menuItem);
}
