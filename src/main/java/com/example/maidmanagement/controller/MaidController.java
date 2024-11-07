package com.example.maidmanagement.controller;

import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.service.MaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maids")
public class MaidController {

    @Autowired
    private MaidService maidService;

    // Register a Maid
    @PostMapping("/register")
    public ResponseEntity<Maid> registerMaid(@RequestBody Maid maid) {
        Maid registeredMaid = maidService.registerMaid(maid);
        return ResponseEntity.status(201).body(registeredMaid); // Status 201 - Created
    }

    // Find Maids by PinCode
    @GetMapping("/findByPinCode")
    public ResponseEntity<List<Maid>> getMaidListByPinCode(@RequestParam String pinCode) {
        List<Maid> maids = maidService.getMaidListByPinCode(pinCode);
        return ResponseEntity.ok(maids); // Return the list of maids
    }
}
