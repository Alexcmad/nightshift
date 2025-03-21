package com.alex.nightshift.nightshift.service;

import com.alex.nightshift.nightshift.entity.Playlist;
import com.alex.nightshift.nightshift.entity.User;
import com.alex.nightshift.nightshift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> getByEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.ok(userRepository.findByEmail(email).get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<User> getById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(userRepository.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<User> getByUsername(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            return ResponseEntity.ok(userRepository.findByUsername(username).get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<User> addUser(User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
}
