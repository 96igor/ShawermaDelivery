package com.igorjava.shawarmadelivery.domain.model;

import lombok.Data;

import java.math.BigDecimal;

//@Data @AllArgsConstructor
public class MenuItem {
    private Long id;
    private String name;
    private MenuSection menuSection;
    private BigDecimal price;

    public MenuItem(Long id, String name, MenuSection menuSection, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.menuSection = menuSection;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuSection getMenuSection() {
        return menuSection;
    }

    public void setMenuSection(MenuSection menuSection) {
        this.menuSection = menuSection;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
