package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.GalleryDAO;
import org.example.model.Gallery;
import org.example.service.GalleryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryDAO galleryDAO;

    @Override
    public Gallery save(Gallery gallery) throws Exception {
        if (gallery.getId() != null) {
            throw new Exception("Gallery already exists");
        }
        return galleryDAO.save(gallery);
    }

    @Override
    public Gallery update(Gallery gallery) throws Exception {
        if (gallery.getId() == null) {
            throw new Exception("Gallery id not found");
        }
        return galleryDAO.save(gallery);
    }

    @Override
    public Gallery findById(Integer id) throws Exception {
        return galleryDAO.findById(id).orElseThrow(() -> new Exception("Gallery not found"));
    }

    @Override
    public Page<Gallery> findAll(Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return galleryDAO.findAll(pageRequest);
    }

    @Override
    public void delete(Gallery gallery) {
    galleryDAO.delete(gallery);
    }
}
