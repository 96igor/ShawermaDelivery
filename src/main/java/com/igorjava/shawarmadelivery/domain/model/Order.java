package com.igorjava.shawarmadelivery.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

//@Data
public class Order {
    private Long id;
    private LocalDateTime dateTime;
    private OrderStatus status;
    private User user;
    private List<MenuItem> itemList;
    private Integer totalPrice;

    public Order(Long id, LocalDateTime dateTime, OrderStatus status, User user, List<MenuItem> itemList, Integer totalPrice) {
        this.id = id;
        this.dateTime = dateTime;
        this.status = status;
        this.user = user;
        this.itemList = itemList;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MenuItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<MenuItem> itemList) {
        this.itemList = itemList;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
