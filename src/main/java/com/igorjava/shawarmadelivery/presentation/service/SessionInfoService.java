package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.IMenuItem;
import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.domain.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionInfoService {
    @NotBlank(message = "Name required")
    private String username;
    @NotBlank(message = "Phone number required")
    @Pattern(regexp = "^\\+?\\d+$", message = "Only digits for phone number")
    private String phone;
    @NotBlank(message = "Password required")
    @Size(min = 6, message = "Password should be at last 6 characters")
    private String password;
    @NotBlank(message = "Address required")
    @Size(min = 4, message = "Address must be more than 4 characters")
    private String address;
    @NotBlank(message = "Email required")
    @Email(message = "Email should be valid")
    private String email;
    private String telegram;
    @Size(min = 1, message = "Please, select at least 1 item to place an order.")
    private List<IMenuItem> cart;

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
}

