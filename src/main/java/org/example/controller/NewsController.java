package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.News;
import org.example.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("news")
public class NewsController {


    private final NewsService newsService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<News> save(@RequestBody News news){
        try {
            return new ResponseEntity<>(newsService.save(news), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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
    public ResponseEntity<Page> findAll(@RequestParam String pageLanguage
            , @RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(newsService.findAll(pageLanguage, page, size), HttpStatus.OK);
    }

    @GetMapping(path = "find-all-by-country")
    public ResponseEntity<Page> findAllByCountry(@RequestParam String pageLanguage
            , @RequestParam String country, @RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(newsService.findAllByCountry(pageLanguage, country, page, size), HttpStatus.OK);
    }

    @GetMapping(path = "find-all-by-country-is-not")
    public ResponseEntity<Page> findAllByCountryIsNot(@RequestParam String pageLanguage
            , @RequestParam String country, @RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(newsService.findAllByCountryIsNot(pageLanguage, country, page, size), HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
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
