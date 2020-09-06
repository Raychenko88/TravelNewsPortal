package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Training;
import org.example.model.User;
import org.example.service.TrainingService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("trainings")
public class TrainingController {

    private final TrainingService trainingService;

    @PutMapping
    public ResponseEntity<Training> save(@RequestBody Training training){
        try {
            return new ResponseEntity<>(trainingService.save(training), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping
    public ResponseEntity<Training> update (@RequestBody Training training){
        try {
            return new ResponseEntity<>(trainingService.update(training), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Training> findById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(trainingService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<Page> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(trainingService.findAll(page, size), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try {
            trainingService.delete(trainingService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
