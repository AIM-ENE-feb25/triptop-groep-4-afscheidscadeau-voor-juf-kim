package com.example.demo.adapterPrototype.controller;

import com.example.demo.adapterPrototype.dto.AttractionDto;
import com.example.demo.adapterPrototype.dto.AttractionListDto;
import com.example.demo.adapterPrototype.service.AttractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {
    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("/{location}")
    public ResponseEntity<AttractionListDto> getAttraction(@PathVariable String location) {
        return ResponseEntity.ok(attractionService.fetchAttractions(location));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<AttractionDto> getAttractionById(@PathVariable String id) {
//
//    }
}
