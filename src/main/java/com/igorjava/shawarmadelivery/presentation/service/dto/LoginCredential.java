package com.igorjava.shawarmadelivery.presentation.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginCredential {

    @NotBlank(message = "Email required")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password required")
    @Size(min = 6, message = "Password should be at last 6 characters")
    private String password;

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
}
