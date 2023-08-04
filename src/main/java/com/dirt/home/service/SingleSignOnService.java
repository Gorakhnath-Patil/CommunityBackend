package com.dirt.home.service;

import com.dirt.home.model.SingleSignOn;

public interface SingleSignOnService {
    SingleSignOn saveSingleSignOn(SingleSignOn singleSignOn);
    SingleSignOn getSingleSignOnByUserId(Long userId);
    void deleteSingleSignOnByUserId(Long userId);
}
