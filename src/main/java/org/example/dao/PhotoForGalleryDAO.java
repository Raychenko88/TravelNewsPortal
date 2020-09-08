package org.example.dao;

import org.example.model.News;
import org.example.model.PhotoForGallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoForGalleryDAO extends PagingAndSortingRepository<PhotoForGallery, Integer> {

    Page<PhotoForGallery> findAll(Pageable pageable);

    Page<PhotoForGallery> findAllByGalleryId(Integer galleryId, Pageable pageable);
}
