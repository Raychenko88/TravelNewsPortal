package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.ActionLog;
import org.example.model.User;
import org.example.service.ActionLogService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(" actions")
public class ActionLogController {

    private final ActionLogService actionLogService;

    @PutMapping
    public ResponseEntity<ActionLog> save(@RequestBody ActionLog actionLog){
        try {
            return new ResponseEntity<>(actionLogService.save(actionLog), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping
    public ResponseEntity<ActionLog> update (@RequestBody ActionLog actionLog){
        try {
            return new ResponseEntity<>(actionLogService.update(actionLog), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ActionLog> findById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(actionLogService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<Page> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(actionLogService.findAll(page, size), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        try {
            actionLogService.delete(actionLogService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
