package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/users") //localhost:8081/users
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String register(
            Model model
    ) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute User user,
            Model model
    ) {
        log.info(String.valueOf(user));
        service.createUser(user);
        model.addAttribute("msg", "User registered successfully!");
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm(
            Model model
    ){
        model.addAttribute("email", "");
        model.addAttribute("password", "");
        return "Login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model
    ){
        try {
            log.info(email);
            User user = service.getUserByEmail(email);
            if (user.getPassword().equals(password)) {
                return "redirect:/menu";
            }
            model.addAttribute("error", "Invalid email or password");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "login failed" + e.getMessage());
            return "login";
        }
    }
}
