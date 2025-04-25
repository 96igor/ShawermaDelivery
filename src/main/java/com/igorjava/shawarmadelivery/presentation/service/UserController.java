package com.igorjava.shawarmadelivery.presentation.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users") //localhost:8081/users
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register") //localhost:8081/users/register/name
//    @PostMapping(value = "/new_user")
    public String register(
//            @PathVariable String name,
            @RequestParam String name, //localhost:8081/users/register?name=Ihor
            Model model
    ) {
        model.addAttribute("name", name);
        return "register";
    }

}
