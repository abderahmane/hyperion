package com.lmt.hyperion.service;

import com.lmt.hyperion.dao.SlipsPremium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SlipsPremiumService {
    Page<SlipsPremium> getAll(Pageable pageable);
}