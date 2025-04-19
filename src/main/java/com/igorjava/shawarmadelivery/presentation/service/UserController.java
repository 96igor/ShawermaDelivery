package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.User;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        Logger.getLogger("UserController").info("UserController bean is created!");
        this.service = service;
    }

    public User createUser(User user){
        return service.createUser(user);
    }

    public void deleteUser(User user){
        service.deleteUser(user);
    }

}
