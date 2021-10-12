package com.example.simbirsoft_test.controller;

import com.example.simbirsoft_test.dto.WordResponseDto;
import com.example.simbirsoft_test.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/word")
public class WordController {
    private final WordService wordService;

    @PostMapping("/create")
    public ResponseEntity<List<WordResponseDto>> createWords(@RequestParam("link") String link){
        List<WordResponseDto> response = wordService.createWords(link);

        return ResponseEntity.ok().body(response);
    }
}
