package com.example.maidmanagement.repository;

import com.example.maidmanagement.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByUserId(String userId);
}

