package com.alex.nightshift.nightshift.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "playlist_arrangements",
    joinColumns = @JoinColumn(name="playlist_id"),
    inverseJoinColumns = @JoinColumn(name = "arrangement_id"))
    private List<Arrangement> arrangements;
}
