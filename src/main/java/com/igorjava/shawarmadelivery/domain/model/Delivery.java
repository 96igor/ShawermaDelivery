package com.igorjava.shawarmadelivery.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

//@Data
public class Delivery {
    private Long id;
    private String address;
    private String phone;
    private LocalDateTime dateTime;
    private Order order;

    public Delivery(Long id, String address, String phone, LocalDateTime dateTime, Order order) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.dateTime = dateTime;
        this.order = order;
    }

    public Delivery() {

    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
