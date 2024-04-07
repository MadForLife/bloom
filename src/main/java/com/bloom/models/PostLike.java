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
@Table(name = "post_likes")
public class PostLike extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "posts_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = "post_like_liked_at", updatable = false, nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime likedAt;

    public PostLike() {
    }

    public PostLike(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    @Override
    public String toString() {
        return "PostLike{" +
                "post=" + post +
                ", user=" + user +
                "} " + super.toString();
    }
}
