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
@Table(name = "comment_likes")
public class CommentLike extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "comments_id", nullable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = "comment_like_liked_at", updatable = false, nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime likedAt;

    public CommentLike() {
    }

    public CommentLike(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentLike{" +
                "comment=" + comment +
                ", user=" + user +
                "} " + super.toString();
    }
}
