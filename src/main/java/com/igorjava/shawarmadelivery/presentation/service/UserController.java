package com.igorjava.shawarmadelivery.presentation.service;

public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
}
