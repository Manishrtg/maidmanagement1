package com.example.maidmanagement.repository;

import com.example.maidmanagement.model.Maid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaidRepository extends JpaRepository<Maid, Long> {
    List<Maid> findByPinCode(String pinCode);
}
