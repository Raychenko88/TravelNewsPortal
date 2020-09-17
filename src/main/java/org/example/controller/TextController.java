package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Photo;
import org.example.model.Text;
import org.example.service.TextService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("text")
public class TextController {

    private final TextService textService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Text> save(@RequestBody Text text) {
        try {
            return new ResponseEntity<>(textService.save(text), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Text> update(@RequestBody Text text) {
        try {
            return new ResponseEntity<>(textService.update(text), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Text> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(textService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List> findAll() {
        return new ResponseEntity<>(textService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-news-id")
    public ResponseEntity<List> findAllByNewsId(@RequestParam Integer newsId) {
        return new ResponseEntity<>(textService.findAllByNewsId(newsId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-training-id")
    public ResponseEntity<List> findAllByTrainingId(@RequestParam Integer trainingId) {
        return new ResponseEntity<>(textService.findAllByTrainingId(trainingId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "find-all-by-interview-id")
    public ResponseEntity<List> findAllByInterviewId(@RequestParam Integer interviewId) {
        return new ResponseEntity<>(textService.findAllByInterviewId(interviewId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            textService.delete(textService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
