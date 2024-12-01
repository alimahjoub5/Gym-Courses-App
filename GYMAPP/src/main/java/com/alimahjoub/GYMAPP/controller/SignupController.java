package com.alimahjoub.GYMAPP.controller;

import com.alimahjoub.GYMAPP.model.User;
import com.alimahjoub.GYMAPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignupController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping
    public String signup(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("CLIENT");
        userService.createUser(user);
        return "redirect:/login";
    }
}