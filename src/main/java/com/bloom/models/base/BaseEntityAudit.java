package com.bloom.models.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity implements Serializable {

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntityAudit that = (BaseEntityAudit) o;
        return Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "BaseEntityAudit{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                "} " + super.toString();
    }
}
