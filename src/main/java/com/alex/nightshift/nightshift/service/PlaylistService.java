package com.alex.nightshift.nightshift.service;

import com.alex.nightshift.nightshift.entity.Arrangement;
import com.alex.nightshift.nightshift.entity.Playlist;
import com.alex.nightshift.nightshift.repository.ArrangementRepository;
import com.alex.nightshift.nightshift.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final ArrangementRepository arrangementRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository, ArrangementRepository arrangementRepository) {
        this.playlistRepository = playlistRepository;
        this.arrangementRepository = arrangementRepository;
    }

    public ResponseEntity<Playlist> getPlaylistById(Long playlistId) {
        return ResponseEntity.ok(playlistRepository.findById(playlistId).orElse(null));
    }

    public ResponseEntity<Playlist> addArrangementToPlaylist (Long playlistId, Long arrangementId){
        Playlist playlist = getPlaylistById(playlistId).getBody();
        Arrangement arrangement = arrangementRepository.findById(arrangementId).orElse(null);
        assert playlist != null;
        playlist.addArrangement(arrangement);
        playlistRepository.save(playlist);
        return ResponseEntity.ok(playlist);
    }

    public ResponseEntity<Playlist> deleteArrangementFromPlaylist (Long playlistId, Long arrangementId){
        Playlist playlist = getPlaylistById(playlistId).getBody();
        Arrangement arrangement = arrangementRepository.findById(arrangementId).orElse(null);
        assert playlist != null;
        playlist.removeArrangement(arrangement);
        playlistRepository.save(playlist);
        return ResponseEntity.ok(playlist);
    }

    public ResponseEntity<Playlist> deletePlaylistById(Long playlistId) {
        playlistRepository.deleteById(playlistId);
        return ResponseEntity.ok(playlistRepository.findById(playlistId).orElse(null));
    }

    public ResponseEntity<Playlist> addPlaylist(Playlist playlist) {
        return ResponseEntity.ok(playlistRepository.save(playlist));
    }

    public ResponseEntity<List<Playlist>> findPlaylistsByUserId(Long userId) {
        return ResponseEntity.ok(playlistRepository.findAllByUserId(userId));
    }
}
