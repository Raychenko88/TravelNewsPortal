package org.example.service;

import org.example.model.PhotoForGallery;

import java.util.List;

public interface PhotoForGalleryService {

    PhotoForGallery save(PhotoForGallery photoForGallery);

    PhotoForGallery update(PhotoForGallery photoForGallery);

    PhotoForGallery findById(Integer id);

    List<PhotoForGallery> finAll();

    List<PhotoForGallery> findAllByGallery(Integer id);

    void delete(PhotoForGallery photoForGallery);
}
