package com.dirt.home.service;

import com.dirt.home.model.Star;
import java.util.List;

public interface StarService {
    Star saveStar(Star star);

    void deleteStar(Long starId);

    List<Star> getStarsByUserId(Long userId);

    // Add any other methods as needed
}
