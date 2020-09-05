package org.example.controller;

import org.example.model.News;
import org.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @PutMapping
    public ResponseEntity<News> save(@RequestBody News news){
        News newsFromDB = null;
        try {
            newsFromDB = newsService.save(news);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (newsFromDB == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<News> update (@RequestBody News news){
        News newsFromDB = null;
        try {
            newsFromDB = newsService.update(news);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (newsFromDB == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
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

    @GetMapping(path = "country")
    public ResponseEntity<Page> findAllByCountry(@RequestParam String country
            , @PageableDefault(sort = {"creationTime"}) Pageable pageable){
        return new ResponseEntity<>(newsService.findAllByCountry(country, pageable), HttpStatus.OK);
    }



    @DeleteMapping
    public ResponseEntity delete(@PathVariable News news){
        News newsFromDB = null;
        try {
            newsFromDB = newsService.findById(news.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (newsFromDB == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        newsService.delete(newsFromDB);
        return new ResponseEntity<>(newsFromDB, HttpStatus.OK);
    }
}