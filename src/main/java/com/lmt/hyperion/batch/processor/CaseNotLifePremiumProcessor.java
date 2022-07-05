package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.CaseNotLifePremium;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CaseNotLifePremiumProcessor implements ItemProcessor<CaseNotLifePremium, CaseNotLifePremium> {

    @Override
    public CaseNotLifePremium process(CaseNotLifePremium caseNotLifePremium) {
        caseNotLifePremium.setId(caseNotLifePremium.get_id().getOid());

        caseNotLifePremium.setSlipePrimeId(caseNotLifePremium.getSlipesPrimeId().getOid());

        return caseNotLifePremium;
    }
}
