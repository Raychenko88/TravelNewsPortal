package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.PhotoForGalleryDAO;
import org.example.model.PhotoForGallery;
import org.example.service.PhotoForGalleryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class PhotoForGalleryServiceImpl implements PhotoForGalleryService {

    private final PhotoForGalleryDAO photoForGalleryDAO;

    @Override
    public PhotoForGallery save(PhotoForGallery photoForGallery) {
        if (photoForGallery.getId() != null) {
            try {
                throw new Exception("PhotoForGallery already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return photoForGalleryDAO.save(photoForGallery);
    }

    @Override
    public PhotoForGallery update(PhotoForGallery photoForGallery) {
        if (photoForGallery.getId() == null) {
            try {
                throw new Exception("PhotoForGallery id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return photoForGalleryDAO.save(photoForGallery);
    }

    @Override
    public PhotoForGallery findById(Integer id) {
        Optional<PhotoForGallery> photoForGallery = ofNullable(photoForGalleryDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return photoForGallery.get();
    }

    @Override
    public Page<PhotoForGallery> findAll(Integer page, Integer size) {
        if (page > 0) {
            page--;
        } else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return photoForGalleryDAO.findAll(pageRequest);
    }

    @Override
    public Page<PhotoForGallery> findAllByGallery(Integer id, Integer page, Integer size) {
        if (page > 0) {
            page--;
        } else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return photoForGalleryDAO.findAllByGalleryId(id, pageRequest);
    }

    @Override
    public void delete(PhotoForGallery photoForGallery) {
        photoForGalleryDAO.delete(photoForGallery);
    }
}
