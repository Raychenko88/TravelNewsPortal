package org.example.dao;

import org.example.model.PhotoForGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoForGalleryDAO extends JpaRepository<PhotoForGallery, Integer> {

    List<PhotoForGallery> findAllByNewsId(Integer id);
}
