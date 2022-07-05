package com.lmt.hyperion.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lmt.hyperion.dao.Model;
import com.lmt.hyperion.dao.RecView;
import com.lmt.hyperion.dao.SlipsPremium;
import com.lmt.hyperion.service.SlipsPremiumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class SlipsPremiumController {

    private final SlipsPremiumService slipsPremiumService;

    public SlipsPremiumController(SlipsPremiumService slipsPremiumService) {

        this.slipsPremiumService = slipsPremiumService;
    }

    @GetMapping( "/rec")
    public Page<Model> rec(Pageable pageable){
        return slipsPremiumService.getAll(pageable);
    }

}
