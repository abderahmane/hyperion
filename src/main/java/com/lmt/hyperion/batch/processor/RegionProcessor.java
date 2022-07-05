package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.Region;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class RegionProcessor implements ItemProcessor<Region, Region> {

    @Override
    public Region process(Region region) {
        region.setId(region.get_id().getOid());
        return region;
    }
}
