package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Photo;
import org.example.model.Video;
import org.example.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("video")
public class VideoController {

    private final VideoService videoService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Video> save(@RequestBody Video video) {
        try {
            return new ResponseEntity<>(videoService.save(video), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Video> update(@RequestBody Video video) {
        try {
            return new ResponseEntity<>(videoService.update(video), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Video> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(videoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List> findAll() {
        return new ResponseEntity<>(videoService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-news-id")
    public ResponseEntity<List> findAllByNewsId(@RequestParam Integer newsId
    ) {
        return new ResponseEntity<>(videoService.findAllByNewsId(newsId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-training-id")
    public ResponseEntity<List> findAllByTrainingId(@RequestParam Integer trainingId
    ) {
        return new ResponseEntity<>(videoService.findAllByTrainingId(trainingId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-interview-id")
    public ResponseEntity<List> findAllByInterviewId(@RequestParam Integer interviewId
    ) {
        return new ResponseEntity<>(videoService.findAllByInterviewId(interviewId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            videoService.delete(videoService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
