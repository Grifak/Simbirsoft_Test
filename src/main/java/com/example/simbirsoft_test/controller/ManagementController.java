package com.example.simbirsoft_test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/management")
@RestController
public class ManagementController {

    @GetMapping("/download")
    public ResponseEntity download(HttpServletResponse servletResponse){
        //TODO скачать файл
        Boolean result = true;

        return ResponseEntity.ok().body(result);
    }
}
