package com.dirt.home.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    String uploadMedia(MultipartFile file);
    Resource loadMediaAsResource(String filename);
    // Other methods for media service, if any
	Resource getMediaById(Long mediaId);
}
