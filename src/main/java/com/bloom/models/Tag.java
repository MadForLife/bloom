package com.bloom.models;

import com.bloom.models.base.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "tags")
public class Tag extends BaseEntityAudit {

    @Column(name = "tag_name", length = 50, unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", posts=" + posts +
                "} " + super.toString();
    }
}
