package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.SlipsPremium;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class SlipsPremiumProcessor implements ItemProcessor<SlipsPremium, SlipsPremium> {

    @Override
    public SlipsPremium process(SlipsPremium slipsPremium) {
        slipsPremium.setId(slipsPremium.get_id().getOid());

        return slipsPremium;
    }
}
