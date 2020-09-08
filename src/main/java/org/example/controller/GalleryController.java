package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Gallery;
import org.example.model.User;
import org.example.service.GalleryService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("galleries")
public class GalleryController {

    private final GalleryService galleryService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Gallery> save(@RequestBody Gallery gallery){
        try {
            return new ResponseEntity<>(galleryService.save(gallery), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Gallery> update (@RequestBody Gallery gallery){
        try {
            return new ResponseEntity<>(galleryService.update(gallery), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Gallery> findById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(galleryService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<Page> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(galleryService.findAll(page, size), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try {
            galleryService.delete(galleryService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
