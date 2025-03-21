package com.alex.nightshift.nightshift.service;

import com.alex.nightshift.nightshift.entity.Arrangement;
import com.alex.nightshift.nightshift.entity.User;
import com.alex.nightshift.nightshift.repository.ArrangementRepository;
import com.alex.nightshift.nightshift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrangementService {
    private final ArrangementRepository arrangementRepository;
    private final UserRepository userRepository;

    public ArrangementService(ArrangementRepository arrangementRepository, UserRepository userRepository) {
        this.arrangementRepository = arrangementRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Arrangement> saveArrangement(Long uploaderId, Arrangement arrangement) {
        User uploader = userRepository.findById(uploaderId).orElse(null);
        arrangement.setUploader(uploader);
        return ResponseEntity.ok(arrangementRepository.save(arrangement));
    }

    public ResponseEntity<Arrangement> updateArrangement(Arrangement arrangement) {
        return ResponseEntity.ok(arrangementRepository.save(arrangement));
    }

    public ResponseEntity<Arrangement> deleteArrangement(Arrangement arrangement) {
        arrangementRepository.delete(arrangement);
        return ResponseEntity.ok(arrangement);
    }

    public ResponseEntity<Arrangement> getArrangementById(Long id) {
        if (arrangementRepository.existsById(id)) {
            return ResponseEntity.ok(arrangementRepository.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Arrangement>> getArrangements() {
        return ResponseEntity.ok(arrangementRepository.findAll());
    }

    public ResponseEntity<List<Arrangement>> getArrangementByTitle(String title) {
        return ResponseEntity.ok(arrangementRepository.findByTitle(title));
    }

    public ResponseEntity<Arrangement> deleteArrangementById(Long id) {
        arrangementRepository.deleteById(id);
        return ResponseEntity.ok(arrangementRepository.findById(id).get());
    }

}
