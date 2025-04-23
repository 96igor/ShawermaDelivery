package com.igorjava.shawarmadelivery.presentation.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newUser() {
        return "new_user";
    }

}
