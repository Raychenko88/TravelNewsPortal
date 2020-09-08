//package org.example.dao;
//
//import lombok.RequiredArgsConstructor;
//import org.example.model.Gallery;
//import org.example.model.PhotoForGallery;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class PhotoForGalleryDAOTest {
//
//    @Autowired
//  PhotoForGalleryDAO photoForGalleryDAO;
//
//    @Autowired
//    GalleryDAO galleryDAO;
//
//
//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void findAllByGallery() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
//        PageRequest pageRequest = PageRequest.of(1, 5, sort);
//        Page<PhotoForGallery> list = photoForGalleryDAO.findAllByGallery(25, pageRequest);
//
//        for (PhotoForGallery p : list) {
//            System.out.println(p);
//        }
//
//    }
//}