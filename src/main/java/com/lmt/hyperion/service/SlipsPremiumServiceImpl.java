package com.lmt.hyperion.service;

import com.lmt.hyperion.dao.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlipsPremiumServiceImpl implements SlipsPremiumService {

    @PersistenceContext
    private EntityManager em;
    private ModelMapper modelMapper;

    public SlipsPremiumServiceImpl() {
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
    public Page<Model> getAll(ModelSaerch model) {
        TypedQuery<SlipsPremium> list = em.createQuery(getQuery(model, "s"), SlipsPremium.class);
        TypedQuery<SlipsPremium> queryList = buildPram(model, list);
        TypedQuery<Long> total = em.createQuery(getQuery(model, "count(*)"), Long.class);
        TypedQuery<Long> queryTotal = buildPram(model, total);
        long totalCount = queryTotal.getSingleResult();
        int page = model.getPage();
        int size = model.getSize() > 0 ? model.getSize() : 10;
        queryList.setFirstResult(page * size);
        queryList.setMaxResults(size);
        List<SlipsPremium> result = queryList.getResultList();
        return new PageImpl<>(result.stream().map(modelMapper::toDto).collect(Collectors.toList()), PageRequest.of(page, size), totalCount);
    }

    public static <T> TypedQuery<T> buildPram(ModelSaerch modelSaerch, TypedQuery<T> query) {
        if (modelSaerch.getBranch() != null) {
            query.setParameter("pBranch", modelSaerch.getBranch());
        }
        if (modelSaerch.getCountry() != null) {
            query.setParameter("pCountry", modelSaerch.getCountry());
        }

        if (modelSaerch.getCedants() != null) {
            query.setParameter("pCedants", modelSaerch.getCedants());
        }
        if (modelSaerch.getConfirmationStatus() != null) {
            query.setParameter("pConfirmationStatus", modelSaerch.getConfirmationStatus());
        }
        if (modelSaerch.getValidationStatus() != null) {
            query.setParameter("pValidationStatus", modelSaerch.getValidationStatus());
        }
        return query;
    }

    public static String getQuery(ModelSaerch modelSaerch, String object) {
        String hql = "SELECT " + object + " FROM SlipsPremium s where s.id != null ";
        if (modelSaerch.getBranch() != null) {
            hql += " and s.branch = :pBranch ";
        }
        if (modelSaerch.getCountry() != null) {
            hql += " and s.country = :pCountry ";
        }

        if (modelSaerch.getCedants() != null) {
            hql += " and s.cedants = :pCedants ";
        }
        if (modelSaerch.getConfirmationStatus() != null) {
            hql += " and s.confirmationStatus = :pConfirmationStatus ";
        }
        if (modelSaerch.getValidationStatus() != null) {
            hql += " and s.validationStatus = :pValidationStatus ";
        }

        return hql;
    }

}
