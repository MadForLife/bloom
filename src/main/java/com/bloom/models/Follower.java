package com.bloom.models;

import com.bloom.models.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "followers")
public class Follower extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "following_id", nullable = false)
    private User following;

    @CreationTimestamp
    @Column(name = "followed_at", updatable = false, nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime followedAt;

    public Follower() {
    }

    public Follower(User follower, User following) {
        this.follower = follower;
        this.following = following;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "follower=" + follower +
                ", following=" + following +
                "} " + super.toString();
    }
}
