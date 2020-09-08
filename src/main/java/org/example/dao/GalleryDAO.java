package org.example.dao;

import org.example.model.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryDAO extends PagingAndSortingRepository<Gallery, Integer> {

    Page<Gallery> findAll(Pageable pageable);
}
