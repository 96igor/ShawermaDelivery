package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.User;

public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public User createUser(User user){
        return service.createUser(user);
    }

    public void deleteUser(User user){
        service.deleteUser(user);
    }

}
