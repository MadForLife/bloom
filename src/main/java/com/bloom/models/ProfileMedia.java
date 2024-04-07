package com.bloom.models;

import com.bloom.models.base.BaseEntityAudit;
import com.bloom.models.enums.ProfileMediaType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "users_profile_media")
public class ProfileMedia extends BaseEntityAudit {

    @Column(name = "upm_media_path", length = 2000, nullable = false)
    private String mediaPath;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "upm_media_type", nullable = false)
    private ProfileMediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    public ProfileMedia() {
    }

    public ProfileMedia(String mediaPath, ProfileMediaType mediaType, User user) {
        this.mediaPath = mediaPath;
        this.mediaType = mediaType;
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProfileMedia{" +
                "mediaPath='" + mediaPath + '\'' +
                ", mediaType=" + mediaType +
                "} " + super.toString();
    }
}
