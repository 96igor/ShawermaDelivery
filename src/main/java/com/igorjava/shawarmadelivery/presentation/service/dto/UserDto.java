package com.igorjava.shawarmadelivery.presentation.service.dto;

import com.igorjava.shawarmadelivery.domain.model.IUser;
import jakarta.validation.constraints.*;

public class UserDto implements IUser {
    private Long id;
    @NotBlank(message = "Name required")
    private String name;
    @NotBlank(message = "Email required")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password required")
    @Size(min = 6, message = "Password should be at last 6 characters")
    private String password;
    private String telegram;
    @NotBlank(message = "Phone number required")
    @Pattern(regexp = "^\\+?\\d+$", message = "Only digits for phone number")
    private String phone;
    @NotBlank(message = "Address required")
    @Size(min = 4, message = "Address must be more than 4 characters")
    private String address;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String password, String telegram, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telegram = telegram;
        this.phone = phone;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telegram='" + telegram + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

