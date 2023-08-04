package com.dirt.home.service;

import com.dirt.home.model.Star;
import com.dirt.home.repository.StarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;

    public StarServiceImpl(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    @Override
    public Star saveStar(Star star) {
        return starRepository.save(star);
    }

    @Override
    public void deleteStar(Long starId) {
        starRepository.deleteById(starId);
    }

    @Override
    public List<Star> getStarsByUserId(Long userId) {
        return starRepository.findAllByUserUserID(userId); // Corrected method name
    }
}
