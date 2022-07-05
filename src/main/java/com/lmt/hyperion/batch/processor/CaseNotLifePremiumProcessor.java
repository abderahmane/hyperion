package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.BranchRepository;
import com.lmt.hyperion.dao.CaseNotLifePremium;
import com.lmt.hyperion.dao.CedantRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CaseNotLifePremiumProcessor implements ItemProcessor<CaseNotLifePremium, CaseNotLifePremium> {

    private final BranchRepository branchRepository;
    private final CedantRepository cedantRepository;

    public CaseNotLifePremiumProcessor(BranchRepository branchRepository, CedantRepository cedantRepository) {
        this.branchRepository = branchRepository;
        this.cedantRepository = cedantRepository;
    }

    @Override
    public CaseNotLifePremium process(CaseNotLifePremium caseNotLifePremium) {
        caseNotLifePremium.setId(caseNotLifePremium.get_id().getOid());

        caseNotLifePremium.setSlipePrimeId(caseNotLifePremium.getSlipesPrimeId().getOid());
        if(caseNotLifePremium.getBranchesId() != null){
            branchRepository.findById(caseNotLifePremium.getBranchesId().getOid()).ifPresent(b -> {
                caseNotLifePremium.setBranch(b.getName());
            } );
        }

        if(caseNotLifePremium.getCedantsId() != null){
            cedantRepository.findById(caseNotLifePremium.getCedantsId().getOid()).ifPresent(c -> {
                caseNotLifePremium.setCountry(c.getCountry().getName());
                caseNotLifePremium.setCedants(c.getName());
            } );
        }

        return caseNotLifePremium;
    }
}
