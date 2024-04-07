package com.bloom.models;

import com.bloom.models.base.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "posts")
public class Post extends BaseEntityAudit {

    @Column(name = "post_title", length = 100, nullable = false)
    private String title;

    @Column(name = "post_description", length = 2200)
    private String description;

    @Column(name = "post_media_path", length = 2000, nullable = false)
    private String mediaPath;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User author;

    @ManyToMany
    @JoinTable(name = "gallery_has_posts",
            joinColumns = @JoinColumn(name = "galleries_id"),
            inverseJoinColumns = @JoinColumn(name = "posts_id"))
    private Set<Gallery> galleries;

    @ManyToMany
    @JoinTable(name = "post_has_tags",
            joinColumns = @JoinColumn(name = "posts_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private Set<Tag> tags;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "post")
    private Set<PostLike> likes;

    public Post() {
    }

    public Post(String title, String description, String mediaPath, User author) {
        this.title = title;
        this.description = description;
        this.mediaPath = mediaPath;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author=" + author +
                ", mediaPath='" + mediaPath + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
