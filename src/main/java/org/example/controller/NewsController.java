package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.News;
import org.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("news")
public class NewsController {


    private final NewsService newsService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<News> save(@RequestBody News news){
        try {
            return new ResponseEntity<>(newsService.save(news), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<News> update (@RequestBody News news){
        try {
            return new ResponseEntity<>(newsService.update(news), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<News> findById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(newsService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<Page> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(newsService.findAll(page, size), HttpStatus.OK);
    }

    @GetMapping(path = "find-all-by-country")
    public ResponseEntity<Page> findAllByCountry(@RequestParam String country
            , @RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(newsService.findAllByCountry(country, page, size), HttpStatus.OK);
    }



    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try {
            newsService.delete(newsService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
