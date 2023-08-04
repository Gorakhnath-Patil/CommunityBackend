package com.dirt.home.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Stars")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Add any additional fields as needed, e.g., post, comment, etc.

    // Constructors, getters, and setters

    public Star() {
    }

    public Star(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
