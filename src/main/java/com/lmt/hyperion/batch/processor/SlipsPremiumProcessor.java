package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.CaseNotLifePremiumRepository;
import com.lmt.hyperion.dao.SlipsPremium;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlipsPremiumProcessor implements ItemProcessor<SlipsPremium, SlipsPremium> {

    @Autowired
    CaseNotLifePremiumRepository caseNotLifePremiumRepository;
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


        return slipsPremium;
    }
}
