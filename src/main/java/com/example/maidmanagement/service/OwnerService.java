package com.example.maidmanagement.service;

import com.example.maidmanagement.model.Owner;
import com.example.maidmanagement.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    // Register an Owner
    public Owner registerOwner(Owner owner) {
        return ownerRepository.save(owner); // Saves the owner to the database
    }

    // Find Owner by UserId (for login)
    public Optional<Owner> findOwnerByUserId(String userId) {
        return ownerRepository.findByUserId(userId); // Retrieves owner by userId
    }
}
