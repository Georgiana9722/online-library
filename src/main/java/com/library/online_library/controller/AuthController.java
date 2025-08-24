package com.library.online_library.controller;

import com.library.online_library.model.User;
import com.library.online_library.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User authenticated = userService.authenticate(user.getUsername(), user.getPassword());
        if (authenticated != null) {
            return ResponseEntity.ok("Login successful for: " + authenticated.getUsername() + " (Role: " + authenticated.getRole() + ")");
        } else {
            return ResponseEntity.status(401).body("Invalid username/email or password");
        }
    }
}
