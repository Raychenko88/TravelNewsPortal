package org.example.dao;

import org.example.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryDAO extends JpaRepository<Gallery, Integer> {
}
