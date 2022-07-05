package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.Country;
import com.lmt.hyperion.dao.Region;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CountryProcessor implements ItemProcessor<Country, Country> {

    @Override
    public Country process(Country country) {
        country.setId(country.get_id().getOid());
        Region region = new Region();
        region.setId(country.getRegionId().getOid());
        country.setRegion(region);
        return country;
    }
}
