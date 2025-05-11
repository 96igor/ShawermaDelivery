package com.igorjava.shawarmadelivery.domain.model;

import java.util.List;

public class SessionInfo {
    private String username;
    private String phone;
    private String address;
    private List<MenuItem> cart;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MenuItem> getCart() {
        return cart;
    }

    public void setCart(List<MenuItem> cart) {
        this.cart = cart;
    }

    public SessionInfo(String username, String phone, String address, List<MenuItem> cart) {
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.cart = cart;
    }
}
