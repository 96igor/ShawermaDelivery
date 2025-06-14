package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.interractor.MenuItemInteractor;
import com.igorjava.shawarmadelivery.domain.repo.MenuItemRepo;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService extends MenuItemInteractor {

    public MenuItemService(MenuItemRepo repo) {
        super(repo);
    }
}
