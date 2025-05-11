package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.List;

@Service
@SessionScope
public class SessionInfoService {
    private String username;
    private String phone;
    private String address;
    private List<MenuItem> cart;

    public SessionInfoService() {}

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
}

