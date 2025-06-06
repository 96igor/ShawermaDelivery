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
}
