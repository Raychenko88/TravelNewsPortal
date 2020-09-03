package org.example.service;

import org.example.model.Gallery;

import java.util.List;

public interface GalleryService {

    Gallery save(Gallery gallery);

    Gallery update(Gallery gallery);

    Gallery findById(Integer id);

    List<Gallery> findAll();

    void delete(Gallery gallery);
}
