package com.dirt.home.service;

import org.springframework.stereotype.Service;

import com.dirt.home.model.SingleSignOn;
import com.dirt.home.repository.SingleSignOnRepository;

@Service
public class SingleSignOnServiceImpl implements SingleSignOnService {

    private final SingleSignOnRepository singleSignOnRepository;

    public SingleSignOnServiceImpl(SingleSignOnRepository singleSignOnRepository) {
        this.singleSignOnRepository = singleSignOnRepository;
    }

    @Override
    public SingleSignOn saveSingleSignOn(SingleSignOn singleSignOn) {
        return singleSignOnRepository.save(singleSignOn);
    }

    @Override
    public SingleSignOn getSingleSignOnByUserId(Long userId) {
        return singleSignOnRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteSingleSignOnByUserId(Long userId) {
        singleSignOnRepository.deleteById(userId);
    }
}
