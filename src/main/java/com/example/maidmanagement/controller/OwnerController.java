package com.example.maidmanagement.controller;

import com.example.maidmanagement.model.LoginRequest;
import com.example.maidmanagement.model.Owner;
import com.example.maidmanagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Use Spring's PasswordEncoder

    // Register an Owner
    @PostMapping("/register")
    public ResponseEntity<Owner> registerOwner(@RequestBody Owner owner) {
        // Hash the password before saving
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        Owner registeredOwner = ownerService.registerOwner(owner);
        return ResponseEntity.status(201).body(registeredOwner); // Status 201 - Created
    }

    // Owner Login (using bcrypt to compare the password)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Optional<Owner> owner = ownerService.findOwnerByUserId(loginRequest.getUserId());
        if (owner.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), owner.get().getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials"); // Status 401 - Unauthorized
    }
}
