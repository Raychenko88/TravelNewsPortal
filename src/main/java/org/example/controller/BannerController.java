package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Banner;
import org.example.model.User;
import org.example.service.BannerService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("banners")
public class BannerController {

    private final BannerService bannerService;

    @PutMapping
    public ResponseEntity<Banner> save(@RequestBody Banner banner){
        try {
            return new ResponseEntity<>(bannerService.save(banner), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping
    public ResponseEntity<Banner> update (@RequestBody Banner banner){
        try {
            return new ResponseEntity<>(bannerService.update(banner), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Banner> findById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(bannerService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try {
            bannerService.delete(bannerService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
