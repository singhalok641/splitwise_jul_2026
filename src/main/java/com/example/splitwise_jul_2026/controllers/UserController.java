package com.example.splitwise_jul_2026.controllers;

import com.example.splitwise_jul_2026.exceptions.UserNotFoundException;
import com.example.splitwise_jul_2026.models.User;
import com.example.splitwise_jul_2026.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User registerUser(String name, String phone, String password) {
        return userService.registerUser(name, phone, password);
    }

    public User updateProfile(String newPassword, Long userId) {
        return userService.updateProfile(userId, newPassword);
    }
}
