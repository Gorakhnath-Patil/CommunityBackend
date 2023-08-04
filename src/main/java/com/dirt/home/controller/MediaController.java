package com.dirt.home.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dirt.home.service.MediaService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    // Endpoint to upload media
    @PostMapping("/upload")
    public ResponseEntity<String> uploadMedia(@RequestParam("file") MultipartFile file) {
        String mediaUrl = mediaService.uploadMedia(file);
        return ResponseEntity.ok(mediaUrl);
    }

    // Endpoint to retrieve media by ID
    @GetMapping("/{mediaId}")
    public ResponseEntity<Resource> getMediaById(@PathVariable Long mediaId) {
        Resource mediaResource = mediaService.getMediaById(mediaId);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Set the appropriate media type
                .body(mediaResource);
    }

    // Add other endpoints as needed for media management, e.g., delete media, update media metadata, etc.
}
