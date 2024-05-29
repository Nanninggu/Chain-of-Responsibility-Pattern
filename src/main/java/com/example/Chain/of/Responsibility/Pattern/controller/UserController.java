package com.example.Chain.of.Responsibility.Pattern.controller;

import com.example.Chain.of.Responsibility.Pattern.dto.UserRequest;
import com.example.Chain.of.Responsibility.Pattern.handler.Handler;
import com.example.Chain.of.Responsibility.Pattern.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Handler handler;
    private final UserMapper userMapper;

    @Autowired
    public UserController(Handler handler, UserMapper userMapper) {
        this.handler = handler;
        this.userMapper = userMapper;
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        try {
            handler.handleRequest(userRequest);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create user: " + e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok(userMapper.getUsers().toString());
    }

}
