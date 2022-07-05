package com.lmt.hyperion.service;

import com.lmt.hyperion.dao.SlipsPremium;
import com.lmt.hyperion.dao.SlipsPremiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SlipsPremiumServiceImpl implements SlipsPremiumService {

    private final SlipsPremiumRepository slipsPremiumRepository;

    public SlipsPremiumServiceImpl(SlipsPremiumRepository slipsPremiumRepository) {
        this.slipsPremiumRepository = slipsPremiumRepository;
    }

    @Override
    public Page<SlipsPremium> getAll(Pageable pageable) {
        return slipsPremiumRepository.findAll(pageable);
    }
}
