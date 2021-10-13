package com.example.simbirsoft_test.controller;

import com.example.simbirsoft_test.dto.WordResponseDto;
import com.example.simbirsoft_test.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete")
    public ResponseEntity<List<WordResponseDto>> deleteAllWords(){
        List<WordResponseDto> response = wordService.deleteAllWords();

        return ResponseEntity.ok().body(response);
    }
}
