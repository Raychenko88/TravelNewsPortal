package org.example.service.impl;

import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.example.dao.PhotoForGalleryDAO;
import org.example.model.PhotoForGallery;
import org.example.service.PhotoForGalleryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoForGalleryServiceImpl implements PhotoForGalleryService {

    private final PhotoForGalleryDAO photoForGalleryDAO;

    @Override
    public PhotoForGallery save(PhotoForGallery photoForGallery) throws Exception {
        if (photoForGallery.getId() != null) {
            throw new Exception("PhotoForGallery already exists");
        }
        return photoForGalleryDAO.save(photoForGallery);
    }

    @Override
    public PhotoForGallery update(PhotoForGallery photoForGallery) throws Exception {
        if (photoForGallery.getId() == null) {
            throw new Exception("PhotoForGallery id not found");
        }
        return photoForGalleryDAO.save(photoForGallery);
    }

    @Override
    public PhotoForGallery findById(Integer id) throws Exception {
        return photoForGalleryDAO.findById(id).orElseThrow(() -> new Exception("PhotoForGallery not found"));
    }

    @Override
    public Page<PhotoForGallery> findAll(Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return photoForGalleryDAO.findAll(pageRequest);
    }

    @Override
    public Page<PhotoForGallery> findAllByGallery(Integer id, Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
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
