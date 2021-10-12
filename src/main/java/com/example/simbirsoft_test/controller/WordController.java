package com.example.simbirsoft_test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/word")
public class WordController {

    @PostMapping("/create")
    public ResponseEntity createWords(@RequestParam("link") String link){
        //TODO прочитать страницу и заполнить БД
        Boolean result = true;

        return ResponseEntity.ok().body(result);
    }
}
