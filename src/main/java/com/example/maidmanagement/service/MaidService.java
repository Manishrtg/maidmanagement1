package com.example.maidmanagement.service;

import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.repository.MaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaidService {

    @Autowired
    private MaidRepository maidRepository;

    // Register a Maid
    public Maid registerMaid(Maid maid) {
        return maidRepository.save(maid); // Saves the maid to the database
    }

    // Find Maids by PinCode
    public List<Maid> getMaidListByPinCode(String pinCode) {
        return maidRepository.findByPinCode(pinCode); // Retrieves maids by pin code
    }
}
