package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.PhotoForGallery;
import org.example.service.PhotoForGalleryService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("photo")
public class PhotoForGalleryController {

    private final PhotoForGalleryService photoForGalleryService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PhotoForGallery> save(@RequestBody PhotoForGallery photoForGallery) {
        try {
            return new ResponseEntity<>(photoForGalleryService.save(photoForGallery), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PhotoForGallery> update(@RequestBody PhotoForGallery photoForGallery) {
        try {
            return new ResponseEntity<>(photoForGalleryService.update(photoForGallery), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<PhotoForGallery> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(photoForGalleryService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<Page> findAll(@RequestParam Integer page, @RequestParam Integer size) {
        return new ResponseEntity<>(photoForGalleryService.findAll(page, size), HttpStatus.OK);
    }

    @GetMapping(path = "find-all-by-gallery")
    public ResponseEntity<Page> findAllBygallery(@RequestParam Integer id
            , @RequestParam Integer page, @RequestParam Integer size) {
        return new ResponseEntity<>(photoForGalleryService.findAllByGallery(id, page, size), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            photoForGalleryService.delete(photoForGalleryService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
