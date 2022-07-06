package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SlipsPremiumProcessor implements ItemProcessor<SlipsPremium, SlipsPremium> {

    private final CaseNotLifePremiumRepository caseNotLifePremiumRepository;
    private final CedantRepository cedantRepository;
    private final BranchRepository branchRepository;

    public SlipsPremiumProcessor(CaseNotLifePremiumRepository caseNotLifePremiumRepository, CedantRepository cedantRepository, BranchRepository branchRepository) {
        this.caseNotLifePremiumRepository = caseNotLifePremiumRepository;
        this.cedantRepository = cedantRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public SlipsPremium process(SlipsPremium slipsPremium) {
        slipsPremium.setId(slipsPremium.get_id().getOid());

        Float totalPremiumHt = caseNotLifePremiumRepository.totalPremium(slipsPremium.getId());
        if(totalPremiumHt != null){
            slipsPremium.setRec((float) (totalPremiumHt * 0.36));
        }
        else{
            slipsPremium.setRec(0f);
        }

        if(slipsPremium.getCedantsId() != null){
            cedantRepository.findById(slipsPremium.getCedantsId().getOid()).ifPresent(c -> {
                slipsPremium.setCountry(c.getCountry().getName());
                slipsPremium.setCedants(c.getName());
            } );
        }

        List<CaseNotLifePremium> bySlipePrimeId = caseNotLifePremiumRepository.findBySlipePrimeId(slipsPremium.getId());
        if(bySlipePrimeId.size() > 1){
            slipsPremium.setBranch(bySlipePrimeId.get(0).getBranch());
        }

        return slipsPremium;
    }
}
