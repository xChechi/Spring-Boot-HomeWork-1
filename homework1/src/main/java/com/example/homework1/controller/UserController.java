package com.example.homework1.controller;

import com.example.homework1.dto.UserRequest;
import com.example.homework1.entity.User;
import com.example.homework1.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll (User user) {

        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findUser (@PathVariable int id) {

        return userService.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable int id) {

        userService.deleteUser(id);
    }

    @PostMapping("/users")
    public void createUser (@Valid @RequestBody UserRequest request) {

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userService.createUser(user);
    }
}
