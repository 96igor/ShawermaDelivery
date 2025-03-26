package com.igorjava.shawarmadelivery.domain.model;

import lombok.Data;

@Data
public class MenuItem {
    private Long id;
    private String name;
    private MenuItem menuItem;
    private Integer price;
}
