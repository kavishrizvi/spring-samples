package com.kavish.tutorials.controller;

import com.kavish.tutorials.service.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserInformation userInformation;

    @GetMapping("/v1/users")
    public String getUsers() throws Exception {
        return userInformation.getUsers();
    }
}
