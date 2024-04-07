package com.bloom.models;

import com.bloom.models.base.BaseEntityAudit;
import com.bloom.models.enums.GalleryVisibility;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "galleries")
public class Gallery extends BaseEntityAudit {

    @Column(name = "gallery_title", length = 100, nullable = false)
    private String title;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gallery_type", nullable = false)
    private GalleryVisibility visibility;

    @Column(name = "gallery_description", length = 2200, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User owner;

    @ManyToMany(mappedBy = "galleries")
    private Set<Post> posts;

    public Gallery() {
    }

    public Gallery(String title, GalleryVisibility visibility, String description, User owner) {
        this.title = title;
        this.visibility = visibility;
        this.description = description;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "title='" + title + '\'' +
                ", visibility=" + visibility +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
