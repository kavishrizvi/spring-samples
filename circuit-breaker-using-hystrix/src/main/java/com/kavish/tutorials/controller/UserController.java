package com.kavish.tutorials.controller;

import com.kavish.tutorials.service.UserInformation;
import com.kavish.tutorials.service.UserInformationImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/circuitbreaker")
public class UserController {

    private final UserInformationImpl userInformation;

    public UserController(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @GetMapping("/user")
    public String getUsers() {
        return userInformation.getUsers();
    }
}