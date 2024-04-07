package com.bloom.repository;

import com.bloom.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
}
