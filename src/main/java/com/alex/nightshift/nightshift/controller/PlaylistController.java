package com.alex.nightshift.nightshift.controller;

import com.alex.nightshift.nightshift.entity.Playlist;
import com.alex.nightshift.nightshift.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    @PostMapping
    public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist playlist) {
        return playlistService.addPlaylist(playlist);
    }

    @PostMapping("/{playlistId}/arrangement/{arrangementId}")
    public ResponseEntity<Playlist> addArrangementToPlaylist(@PathVariable Long playlistId, @PathVariable Long arrangementId) {
        return playlistService.addArrangementToPlaylist(playlistId, arrangementId);
    }

    @PutMapping("/{playlistId}/arrangement/{arrangementId}")
    public ResponseEntity<Playlist> removeArrangementFromPlaylist(@PathVariable Long playlistId, @PathVariable Long arrangementId) {
        return playlistService.deleteArrangementFromPlaylist(playlistId, arrangementId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long id) {
        return playlistService.deletePlaylistById(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Playlist>> getPlaylistByUserId(@PathVariable Long id) {
        return playlistService.findPlaylistsByUserId(id);
    }
}
