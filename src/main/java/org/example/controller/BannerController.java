package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Banner;
import org.example.service.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("banner")
public class BannerController {

    private final BannerService bannerService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Banner> save(@RequestBody Banner banner) {
        try {
            return new ResponseEntity<>(bannerService.save(banner), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Banner> update(@RequestBody Banner banner) {
        try {
            return new ResponseEntity<>(bannerService.update(banner), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Banner> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(bannerService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            bannerService.delete(bannerService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
