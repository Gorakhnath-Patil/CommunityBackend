package com.dirt.home.controller;

import com.dirt.home.model.Star;
import com.dirt.home.service.StarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stars")
public class StarController {

    private final StarService starService;

    public StarController(StarService starService) {
        this.starService = starService;
    }

    // Endpoint to add a star
    @PostMapping
    public ResponseEntity<Star> addStar(@RequestBody Star star) {
        Star savedStar = starService.saveStar(star);
        return new ResponseEntity<>(savedStar, HttpStatus.CREATED);
    }

    // Endpoint to remove a star by ID
    @DeleteMapping("/{starId}")
    public ResponseEntity<Void> removeStar(@PathVariable Long starId) {
        starService.deleteStar(starId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint to get stars by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Star>> getStarsByUserId(@PathVariable Long userId) {
        List<Star> stars = starService.getStarsByUserId(userId);
        return new ResponseEntity<>(stars, HttpStatus.OK);
    }

    // Add other endpoints as needed for managing stars or favorites
}
