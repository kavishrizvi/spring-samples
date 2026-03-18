package com.kavishrizvi.springbootmongodb.controller;

import com.kavishrizvi.springbootmongodb.entity.User;
import com.kavishrizvi.springbootmongodb.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        service.createUser(user);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable ObjectId id) {
        User user = service.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("userName/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        User user = service.getUserByUserName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> removeUser(@PathVariable ObjectId id) {
        service.deleteUserById(id);
        return new ResponseEntity<>("User Removed from the system", HttpStatus.OK);
    }

    @PutMapping("/userName/{userName}")
    public ResponseEntity<String> updateUser(@PathVariable String userName,
                                             @RequestBody User user) {
        service.updateUser(userName, user);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }
}
