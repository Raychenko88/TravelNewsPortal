package org.example.service;

import org.example.model.Gallery;
import org.springframework.data.domain.Page;

public interface GalleryService {

    Gallery save(Gallery gallery);

    Gallery update(Gallery gallery);

    Gallery findById(Integer id);

    Page<Gallery> findAll(Integer page, Integer size);

    void delete(Gallery gallery);
}
