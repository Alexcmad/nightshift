package com.alex.nightshift.nightshift.service;

import com.alex.nightshift.nightshift.entity.Arrangement;
import com.alex.nightshift.nightshift.repository.ArrangementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrangementService {
    private final ArrangementRepository arrangementRepository;

    public ArrangementService(ArrangementRepository arrangementRepository) {
        this.arrangementRepository = arrangementRepository;
    }

    public ResponseEntity<Arrangement> saveArrangement(Arrangement arrangement) {
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
