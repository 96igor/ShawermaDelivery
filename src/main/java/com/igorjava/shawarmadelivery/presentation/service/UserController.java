package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

//import java.util.logging.Logger;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        LoggerFactory.getLogger(UserController.class).info("UserController bean is created!");
        this.service = service;
    }

    public User createUser(User user){
        return service.createUser(user);
    }

    public void deleteUser(User user){
        service.deleteUser(user);
    }

}
