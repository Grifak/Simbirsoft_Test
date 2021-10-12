package com.example.simbirsoft_test.controller;

import com.example.simbirsoft_test.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/management")
@RequiredArgsConstructor
@RestController
public class ManagementController {
    private final WordService wordService;

    @GetMapping("/download")
    public ResponseEntity download(HttpServletResponse servletResponse){
        Boolean result = wordService.downloadFile(servletResponse);

        return ResponseEntity.ok().body(result);
    }
}
