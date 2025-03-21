package com.alex.nightshift.nightshift.controller;

import com.alex.nightshift.nightshift.entity.Arrangement;
import com.alex.nightshift.nightshift.service.ArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arrangements")
public class ArrangementController {
    private final ArrangementService arrangementService;

    @Autowired
    public ArrangementController(ArrangementService arrangementService) {
        this.arrangementService = arrangementService;
    }

    @PostMapping
    public ResponseEntity<Arrangement> createArrangement(@RequestBody Arrangement arrangement) {
        return arrangementService.saveArrangement(arrangement);
    }

    @PutMapping
    public ResponseEntity<Arrangement> updateArrangement(@RequestBody Arrangement arrangement) {
        return arrangementService.updateArrangement(arrangement);
    }

    @DeleteMapping
    public ResponseEntity<Arrangement> deleteArrangement(@RequestBody Arrangement arrangement) {
        return arrangementService.deleteArrangement(arrangement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arrangement> getArrangementById(@PathVariable Long id) {
        return arrangementService.getArrangementById(id);
    }

    @GetMapping
    public ResponseEntity<List<Arrangement>> getAllArrangements() {
        return arrangementService.getArrangements();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Arrangement>> getArrangementByTitle(@PathVariable String title) {
        return arrangementService.getArrangementByTitle(title);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Arrangement> deleteArrangement(@PathVariable Long id) {
        return arrangementService.deleteArrangementById(id);
    }
}
