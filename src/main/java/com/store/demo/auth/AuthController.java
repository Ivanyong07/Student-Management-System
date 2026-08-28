package com.store.demo.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.demo.auth.dto.AuthRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        System.out.println("Username: " + request.getUsername());
        System.out.println("Password: " + request.getPassword());

        return "Login Request Received";
    }

}
