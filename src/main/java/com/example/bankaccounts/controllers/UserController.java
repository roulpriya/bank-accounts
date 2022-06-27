package com.example.bankaccounts.controllers;

import com.example.bankaccounts.dto.CreateUserRequest;
import com.example.bankaccounts.dto.UserResponse;
import com.example.bankaccounts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/")
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }


}
