package org.example.service;

import org.example.model.Gallery;
import org.springframework.data.domain.Page;

public interface GalleryService {

    Gallery save(Gallery gallery) throws Exception;

    Gallery update(Gallery gallery) throws Exception;

    Gallery findById(Integer id) throws Exception;

    Page<Gallery> findAll(Integer page, Integer size);

    void delete(Gallery gallery);
}
