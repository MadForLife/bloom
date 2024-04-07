package com.bloom.models;

import com.bloom.models.base.BaseEntityAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "users")
public class User extends BaseEntityAudit {

    @Column(name = "user_email_address", length = 100, unique = true, nullable = false)
    private String emailAddress;

    @Column(name = "user_display_name", length = 32, nullable = false)
    private String displayName;

    @Column(name = "user_username", length = 32, unique = true, nullable = false)
    private String username;

    @Column(name = "user_password_hash", length = 60, nullable = false)
    private String passwordHash;

    @Column(name = "user_date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Post> posts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_has_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> authorities;

    @OneToMany(mappedBy = "following")
    private Set<Follower> followers;

    @OneToMany(mappedBy = "follower")
    private Set<Follower> following;

    @OneToMany(mappedBy = "owner")
    private Set<Gallery> galleries;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user")
    private Set<PostLike> likedPosts;

    @OneToMany(mappedBy = "user")
    private Set<CommentLike> likedComments;

    @OneToMany(mappedBy = "user")
    private Set<ProfileMedia> profileMedia;

    public User() {
    }

    public User(String emailAddress, String displayName, String username, String passwordHash, LocalDate dateOfBirth) {
        this.emailAddress = emailAddress;
        this.displayName = displayName;
        this.username = username;
        this.passwordHash = passwordHash;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String emailAddress, String displayName, String username, String passwordHash, LocalDate dateOfBirth, Set<Role> authorities) {
        this.emailAddress = emailAddress;
        this.displayName = displayName;
        this.username = username;
        this.passwordHash = passwordHash;
        this.dateOfBirth = dateOfBirth;
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailAddress='" + emailAddress + '\'' +
                ", displayName='" + displayName + '\'' +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                "} " + super.toString();
    }
}
