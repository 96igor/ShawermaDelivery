package com.igorjava.shawarmadelivery.presentation.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users") //localhost:8081/users
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register") //localhost:8081/users/register
//    @PostMapping(value = "/new_user")
    public String register() {
        return "register";
    }

}
