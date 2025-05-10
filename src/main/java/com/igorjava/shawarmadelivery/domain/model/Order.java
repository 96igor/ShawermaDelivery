package com.igorjava.shawarmadelivery.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

//@Data
@NoArgsConstructor
public class Order {
    private Long id;
    private LocalDateTime dateTime;
    private OrderStatus status;
    private User user;
    private List<MenuItem> itemList;
    private BigDecimal totalPrice;

    public Order(Long id, LocalDateTime dateTime, OrderStatus status, User user, List<MenuItem> itemList, BigDecimal totalPrice) {
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", userId=" + (user != null ? user.getId() : null) +
                ", itemCount=" + (itemList != null ? itemList.size() : 0) +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
