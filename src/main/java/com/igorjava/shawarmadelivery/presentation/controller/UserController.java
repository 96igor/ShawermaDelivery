package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.conf.AuthUtils;
import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.presentation.service.SessionInfoService;
import com.igorjava.shawarmadelivery.presentation.service.UserService;
import com.igorjava.shawarmadelivery.presentation.service.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/users") //localhost:8081/users
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService service;
    private final AuthUtils authUtils;
    private final SessionInfoService sessionInfoService;

    public UserController(UserService service, AuthUtils authUtils, SessionInfoService sessionInfoService) {

        this.service = service;
        this.authUtils = authUtils;
        this.sessionInfoService = sessionInfoService;
    }

    @GetMapping("/register")
    public String register(
            Model model
    ) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("user") UserDto user,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
//            log.info("ValidationErrors: {}", result.getFieldError());
//            result.getFieldErrors().forEach(error ->
//                    log.info("Validation error in field '{}': {}", error.getField(), error.getDefaultMessage())
//            );
            model.addAttribute("user", user);
            return "register";
        }

        String encodedPassword= authUtils.encodePassword(user.getPassword());
        user.setPassword(encodedPassword);
        service.createUser(user);
        log.info("User registered: {}", user);
        sessionInfoService.setUserInfo(user);
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
            IUser user = service.getUserByEmail(email);
            if (authUtils.authenticats(password, user.getPassword())){
                sessionInfoService.setUserInfo(user);
                return "redirect:/menu";
            }
            model.addAttribute("error", "Invalid email or password");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "login failed" + e.getMessage());
            return "login";
        }
    }

    @PostMapping("/delete")
    public String deleteUser(
            @RequestParam String email
    ){
            IUser user = service.getUserByEmail(email);
            service.deleteUser(user);
                return "redirect:/users/register";
    }
}
