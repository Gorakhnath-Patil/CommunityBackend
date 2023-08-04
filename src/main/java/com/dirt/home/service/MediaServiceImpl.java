package com.dirt.home.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dirt.home.exceptions.MediaNotFoundException;
import com.dirt.home.exceptions.MediaUploadException;

@Service
public class MediaServiceImpl implements MediaService {

    private static final String MEDIA_BASE_DIR = "media/";

    @Override
    public String uploadMedia(MultipartFile file) {
        try {
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(MEDIA_BASE_DIR + filename);
            Files.copy(file.getInputStream(), filePath);
            return filename;
        } catch (IOException e) {
            throw new MediaUploadException("Failed to upload media", e);
        }
    }

    @Override
    public Resource loadMediaAsResource(String filename) {
        try {
            Path file = Paths.get(MEDIA_BASE_DIR + filename);
            Resource resource = new FileSystemResource(file);

            if (!resource.exists()) {
                throw new MediaNotFoundException("Media not found with filename: " + filename);
            }

            return resource;
        } catch (Exception e) {
            throw new MediaNotFoundException("Failed to load media", e);
        }
    }

	@Override
	public Resource getMediaById(Long mediaId) {
		// TODO Auto-generated method stub
		return null;
	}

    // Implement other methods of MediaService, if any
}
