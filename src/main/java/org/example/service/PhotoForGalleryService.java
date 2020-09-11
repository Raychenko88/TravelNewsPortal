package org.example.service;

import org.example.model.PhotoForGallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhotoForGalleryService {

    PhotoForGallery save(PhotoForGallery photoForGallery);

    PhotoForGallery update(PhotoForGallery photoForGallery);

    PhotoForGallery findById(Integer id);

    Page<PhotoForGallery> findAll(Integer page, Integer size);

    Page<PhotoForGallery> findAllByGallery(Integer id, Integer page, Integer size);

    void delete(PhotoForGallery photoForGallery);
}
