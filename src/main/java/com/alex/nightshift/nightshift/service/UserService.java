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
        return ResponseEntity.ok(userRepository.findByEmail(email).orElse(null));
    }

    public ResponseEntity<User> getById(Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }

    public ResponseEntity<User> getByUsername(String username) {
        return ResponseEntity.ok(userRepository.findByUsername(username).orElse(null));
    }

    public ResponseEntity<User> addUser(User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    public ResponseEntity<User> updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<User> deleteUser(Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }
}
