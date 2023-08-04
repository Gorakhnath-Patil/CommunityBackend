package com.dirt.home.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SingleSignOn")
public class SingleSignOn {

    @Id
    @Column(name = "UserID")
    private Long userID;

    @Column(nullable = false, length = 50)
    private String provider;

    @Column(nullable = false, length = 255)
    private String token;

    @OneToOne
    @MapsId
    @JoinColumn(name = "UserID")
    private User user;

    // Getters and Setters

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
