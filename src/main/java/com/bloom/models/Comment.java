package com.bloom.models;

import com.bloom.models.base.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "comments")
public class Comment extends BaseEntityAudit {

    @Column(name = "comment_content", length = 2200, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "posts_id", nullable = false)
    private Post post;

    @OneToMany
    @JoinColumn(name = "parent_comment_id")
    private Set<Comment> replies;

    @OneToMany(mappedBy = "comment")
    private Set<CommentLike> likes;

    public Comment() {
    }

    public Comment(String content, User user, Post post) {
        this.content = content;
        this.user = user;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", user=" + user +
                ", post=" + post +
                "} " + super.toString();
    }
}
