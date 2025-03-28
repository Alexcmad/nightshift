package com.alex.nightshift.nightshift.repository;

import com.alex.nightshift.nightshift.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findAllByUserId(Long userId);
}
