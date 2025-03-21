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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Arrangement> getArrangements() {
        return arrangements;
    }

    public void addArrangement(Arrangement arrangement) {
        this.arrangements.add(arrangement);
    }

    public void removeArrangement(Arrangement arrangement) {
        this.arrangements.remove(arrangement);
    }

    public void setArrangements(List<Arrangement> arrangements) {
        this.arrangements = arrangements;
    }
}
