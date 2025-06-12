package com.igorjava.shawarmadelivery.presentation.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OrderDto {
    @NotBlank(message = "Name required")
    private String username;
    @NotBlank(message = "Address required")
    @Size(min = 4, message = "Address must be more than 4 characters")
    private String address;
    @NotBlank(message = "Phone number required")
    @Pattern(regexp = "^\\+?\\d+$", message = "Only digits for phone number")
    private String phone;

//    public OrderDto() {}

    public OrderDto(String username, String address, String phone) {
        this.username = username;
        this.address = address;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
