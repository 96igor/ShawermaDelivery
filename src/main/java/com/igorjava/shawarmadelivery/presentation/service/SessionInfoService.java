package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.domain.model.MenuItem;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfoService {
    private String username;
    private String phone;
    private String address;
    private String email;
    private List<MenuItem> cart;

    public void setUserInfo(IUser user) {
        setUsername(user.getName());
        setPhone(user.getPhone());
        setAddress(user.getAddress());
        setEmail(user.getEmail());
    }

    public BigDecimal getTotalPrice(){
        return cart.stream().map(MenuItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MenuItem> getCart() {
        return cart;
    }

    public void setCart(List<MenuItem> cart) {
        this.cart = cart;
    }
}

