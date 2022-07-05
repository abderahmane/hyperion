package com.lmt.hyperion.service;

import com.lmt.hyperion.dao.Model;
import com.lmt.hyperion.dao.ModelMapper;
import com.lmt.hyperion.dao.SlipsPremium;
import com.lmt.hyperion.dao.SlipsPremiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SlipsPremiumServiceImpl implements SlipsPremiumService {

    private final SlipsPremiumRepository slipsPremiumRepository;
    private ModelMapper modelMapper;

    public SlipsPremiumServiceImpl(SlipsPremiumRepository slipsPremiumRepository) {
        this.slipsPremiumRepository = slipsPremiumRepository;
        this.modelMapper = new ModelMapper() {
            @Override
            public SlipsPremium toEntity(Model dto) {
                return new SlipsPremium();
            }

            @Override
            public Model toDto(SlipsPremium entity) {
                Model model = new Model();
                model.setBranch(entity.getBranch());
                model.setCedants(entity.getCedants());
                model.setId(entity.getId());
                model.setCountry(entity.getCountry());
                model.setRec(entity.getRec());
                model.setReference(entity.getReference());
                model.setValidationStatus(entity.getValidationStatus());
                model.setConfirmationStatus(entity.getConfirmationStatus());
                return model;
            }

            @Override
            public List<SlipsPremium> toEntity(List<Model> dtoList) {
                return new ArrayList<>();
            }

            @Override
            public List<Model> toDto(List<SlipsPremium> entityList) {
                return entityList.stream().map(this::toDto).collect(Collectors.toList());
            }
        };
    }

    @Override
    public Page<Model> getAll(Pageable pageable) {
        Page<SlipsPremium> all = slipsPremiumRepository.findAll(pageable);
        System.out.println(all.getTotalElements()  + " " + all.getNumberOfElements() + " " + all.getTotalPages());
        return all.map(modelMapper::toDto);
    }
}
