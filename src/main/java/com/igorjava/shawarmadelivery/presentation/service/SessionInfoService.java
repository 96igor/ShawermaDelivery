package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.IMenuItem;
import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.presentation.service.dto.OrderDto;
import com.igorjava.shawarmadelivery.presentation.service.dto.UserDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfoService {
    private String username;
    private String phone;
    private String password;
    private String address;
    private String email;
    private String telegram;
    private List<IMenuItem> cart = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return cart.stream().map(IMenuItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public SessionInfoService() {
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public List<IMenuItem> getCart() {
        return cart;
    }

    public void setCart(List<IMenuItem> cart) {
        this.cart = cart;
    }

    public IUser getUser() {
        User user = new User();
        user.setName(username);
        user.setTelegram(telegram);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);
        return user;
    }

    public void setUserFields(UserDto userDto) {
        this.username = userDto.getName();
        this.password = userDto.getPassword();
        this.address = userDto.getAddress();
        this.phone = userDto.getPhone();
        this.email = userDto.getEmail();
        this.telegram = userDto.getTelegram();

    }

    public void setInfoFromOrderDto(OrderDto orderDto) {
        username = orderDto.getUsername();
        phone = orderDto.getPhone();
        address = orderDto.getAddress();
    }
}

