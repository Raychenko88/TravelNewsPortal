package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Photo;
import org.example.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("photo")
public class PhotoController {

    private final PhotoService photoService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Photo> save(@RequestBody Photo photo) {
        try {
            return new ResponseEntity<>(photoService.save(photo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Photo> update(@RequestBody Photo photo) {
        try {
            return new ResponseEntity<>(photoService.update(photo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Photo> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(photoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List> findAll() {
        return new ResponseEntity<>(photoService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-news-id")
    public ResponseEntity<List> findAllByNewsId(@RequestParam Integer newsId) {
        return new ResponseEntity<>(photoService.findAllByNewsId(newsId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-training-id")
    public ResponseEntity<List> findAllByTrainingId(@RequestParam Integer trainingId) {
        return new ResponseEntity<>(photoService.findAllByTrainingId(trainingId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-interview-id")
    public ResponseEntity<List> findAllByInterviewId(@RequestParam Integer interviewId) {
        return new ResponseEntity<>(photoService.findAllByInterviewId(interviewId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            photoService.delete(photoService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
