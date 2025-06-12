package com.igorjava.shawarmadelivery.presentation.controller;

import com.igorjava.shawarmadelivery.conf.AuthUtils;
import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.presentation.service.SessionInfoService;
import com.igorjava.shawarmadelivery.presentation.service.UserService;
import com.igorjava.shawarmadelivery.presentation.service.dto.LoginCredential;
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

    private final UserService userService;
    private final AuthUtils authUtils;
    private final SessionInfoService sessionInfoService;

    public UserController(UserService userService, AuthUtils authUtils, SessionInfoService sessionInfoService) {

        this.userService = userService;
        this.authUtils = authUtils;
        this.sessionInfoService = sessionInfoService;
    }

    @GetMapping("/register")
    public String register(
            Model model
    ) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("userDto") UserDto userDto,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "register";
        }

        String encodedPassword = authUtils.encodePassword(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        userService.createUser(userDto);
        sessionInfoService.setUserFields(userDto);

        log.info("UserDto POST registeredUser: {}", userDto);
        log.info("sessionInfoService POST registeredUser: {}", sessionInfoService);
        model.addAttribute("msg", "User registered successfully!");
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm(
            Model model
    ){
        model.addAttribute("credential", new LoginCredential());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @Valid @ModelAttribute(name = "credential") LoginCredential credential,
            BindingResult result,
            Model model
    ){
        if (result.hasErrors()) {
            model.addAttribute("user", credential);
            return "login";
        }

        try {
            IUser user = userService.getUserByEmail(credential.getEmail());
            if (authUtils.authenticats(credential.getPassword(), user.getPassword())) {
                log.info("sessionInfoService.getEmail(): {}", sessionInfoService.getEmail());
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
            IUser user = userService.getUserByEmail(email);
            userService.deleteUser(user);
            return "redirect:/users/register";
    }
}
